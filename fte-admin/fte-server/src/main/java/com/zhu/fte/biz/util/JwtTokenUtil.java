package com.zhu.fte.biz.util;

import com.zhu.fte.biz.config.SessionUser;
import com.zhu.fte.biz.security.Authority;
import com.zhu.fte.biz.security.JwtAuthToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * token类
 *
 * @author zhujiqian
 * @date 2021/1/30 8:22
 */
@Slf4j
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    //用户名称
    private static final String USER_NAME = Claims.SUBJECT;

    //创建时间
    private static final String CREATED = "created";

    //权限列表
    private static final String AUTHORITIES = "authorities";


    private static final String SECRET = "zhu#ji@qian";


    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成令牌
     *
     * @param authentication
     * @return
     */
    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>(3);
        claims.put(USER_NAME, SecurityUtil.getUsername());
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authentication.getAuthorities());
        return generateToken(claims);
    }

    /**
     * 生成带时间的令牌
     *
     * @param claims
     * @return
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    public static String getToken(HttpServletRequest request) {
        String token=request.getHeader("Authorization");
        return token;
    }


    public static Authentication getAuthticationToToken(HttpServletRequest request) {
        Authentication authentication = null;
        final String token = getToken(request);
        if (token != null) {
            //请求令牌不能为空
            if (SecurityUtil.getAuthentication() == null) {
                Claims claims = getClaimsFromToken(token);
                //从令牌中获取用户名
                String username= claims.getSubject();
                if (claims == null || username== null || isTokenExpired(claims))
                    return null;
                Object authors = claims.get(AUTHORITIES);
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                if (authors != null && authors instanceof List) {
                    for (Object object : (List) authors) {
                        authorities.add(new Authority((String) ((Map) object).get("authority")));
                    }
                }
                SessionUser.setUserName(username);
                authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
            } else {
                if(validateToken(token)){
                    authentication=SecurityUtil.getAuthentication();
                }
            }
        }
        return authentication;
    }



    public static Boolean validateToken(String token){
        String username=getUserNameFromToken(token);
        return (username.equals(SecurityUtil.getUsername())&&!isTokenExpired(getClaimsFromToken(token)));
    }


    /**
     * 从令牌中获取用户名
     * @param token
     * @return
     */
    public static String getUserNameFromToken(String token){
        String userName;
        try {
            Claims claims=getClaimsFromToken(token);
            userName=claims.getSubject();
        }catch (Exception e){
            userName=null;
        }
        return userName;
    }

    /**
     * 从令牌当中获取用户信息
     *
     * @param token
     * @return
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    public static Boolean isTokenExpired(Claims claim) {
        try {
            Date expiration = claim.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }


    public static JwtAuthToken login(HttpServletRequest request, String userName, String password, AuthenticationManager authenticationManager){

            JwtAuthToken token=new JwtAuthToken(userName,password);
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //执行登陆认证过程
            Authentication authentication=authenticationManager.authenticate(token);
            //认证成功存储认证信息到上下文
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //生成令牌返回给客户端
            token.setToken(JwtTokenUtil.generateToken(authentication));
            return token;

    }


}
