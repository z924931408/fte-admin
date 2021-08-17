package com.zhu.fte.biz.service.impl;

import com.zhu.fte.biz.util.RedisUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2021/8/17 15:07
 */
@Service
public class TestService {

    @Resource
    private RedisUtil redisUtil;

    @Scheduled(fixedRate = 20000)
    public void test(){
        while (true){
            new Thread(()->{
                try {
                    redisUtil.set("names"+ Math.random(),"yue");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
