package com.zhu.fte.biz.security;

import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2021/2/14 18:25
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在!");
        }
        Set<String> permissions = sysUserService.selectPermissionsByName(user.getName());
        List<GrantedAuthority> grantedAuthorities=permissions.stream().map(Authority::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword(), grantedAuthorities);
    }
}
