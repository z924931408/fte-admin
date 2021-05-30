package com.zhu.fte.biz.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2020/12/24 23:42
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page=new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }


    public ConfigurationCustomizer configurationCustomizer(){
        return configuration -> configuration.setObjectWrapperFactory(
                new MybatisMapWrapperFactory()
        );
    }
}
