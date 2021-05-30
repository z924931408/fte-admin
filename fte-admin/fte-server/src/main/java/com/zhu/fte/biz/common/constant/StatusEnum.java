package com.zhu.fte.biz.common.constant;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/5/29 17:20
 */
public enum StatusEnum implements Status{
    OK(200L,"OK"),
    FAIL(400L,"操作失败"),
    LOGIN_ERROR(408L,"账户或密码错误"),
    SERVER_ERROR(500L,"服务器错误"),
    NOT_LOGIN(403L,"未登陆"),
    PARAM_EXCEPTION(410L,"参数异常")


    ;

    private Long code;

    private String message;


    StatusEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Long code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
