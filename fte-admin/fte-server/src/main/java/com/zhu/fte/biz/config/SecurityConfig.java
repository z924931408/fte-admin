package com.zhu.fte.biz.config;

import com.zhu.fte.biz.security.JwtAuthProvider;
import com.zhu.fte.biz.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2021/1/29 23:52
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //.passwordEncoder(NoOpPasswordEncoder.getInstance()) 告诉security客户端密码不需要加密
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance()) ;
    }



    @Override
    protected void configure(HttpSecurity security) throws Exception {
        //使用JWT，禁用csrf
        security.cors().and().csrf().disable()
                //设置请求必须进行权限认证
                .authorizeRequests()
                //跨域预检请求
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                //permitAll()表示所有用户可认证
                .antMatchers(
                        "/webjars/**",
                        "/",
                        "/admin/login*",
                        "/springboot/es"
                ).permitAll()
                //其他所有请求需要身份认证
                .anyRequest().authenticated();
        //退出登录处理
        security.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        //token验证过滤器
        security.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);


    }
}
