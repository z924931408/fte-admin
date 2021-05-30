package com.zhu.fte.biz.security;

import com.google.gson.internal.$Gson$Preconditions;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/5/29 17:45
 */
public class JwtAuthToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID=1L;

    private String token;


    public JwtAuthToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtAuthToken(Object principal, Object credentials, String token) {
        super(principal, credentials);
        this.token = token;
    }

    public JwtAuthToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
