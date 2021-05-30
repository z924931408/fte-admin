package com.zhu.fte.biz.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 *
 * @author zhujiqian
 * @date 2021/2/14 15:59
 */
public class Authority implements GrantedAuthority {
    private static final long serialVersionUID=1L;

    private String authority;

    public Authority(String authority){
        this.authority=authority;
    }

    public void setAuthority(String authority){
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
