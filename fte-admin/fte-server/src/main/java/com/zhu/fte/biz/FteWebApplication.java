package com.zhu.fte.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动器
 *
 * @author zhujiqian
 * @date 2020/7/29 22:53
 */
@ServletComponentScan
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.zhu.fte"})
@MapperScan("com.zhu.fte.biz.mapper")
public class FteWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FteWebApplication.class,args);
    }
}
