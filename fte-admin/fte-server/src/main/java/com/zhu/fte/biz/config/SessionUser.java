package com.zhu.fte.biz.config;

/**
 * 缓存用户信息
 *
 * @author ZJQ
 * @date 2021/7/7 21:50
 */
public class SessionUser {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();



    public static void setUserName(String userName){
        threadLocal.set(userName);
    }


    public static String getUserName(){
        String userName = threadLocal.get();
        return userName;
    }

}
