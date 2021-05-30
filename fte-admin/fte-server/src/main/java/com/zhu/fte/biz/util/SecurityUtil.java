package com.zhu.fte.biz.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * security工具类
 *
 * @author zhujiqian
 * @date 2021/1/30 9:53
 */
public class SecurityUtil {

    /**
     * 获取当前用户
     * @return
     */
    public static String getUsername(){
        String userName=null;
        Authentication authentication=getAuthentication();
        if(authentication==null) return null;
        Object principal=authentication.getPrincipal();
        if(principal!=null&&principal instanceof UserDetails){
            userName=((UserDetails) principal).getUsername();
        }
        return userName;
    }

    /**
     * 获取当前登录信息
     * @return
     */
    public static Authentication getAuthentication(){
        SecurityContext securityContext=SecurityContextHolder.getContext();
        if(securityContext==null) return null;
        return securityContext.getAuthentication();
    }

}
