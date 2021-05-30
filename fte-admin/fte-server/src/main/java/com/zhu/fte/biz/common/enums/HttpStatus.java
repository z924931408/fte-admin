package com.zhu.fte.biz.common.enums;

public enum HttpStatus implements status{
    OK(200L,"OK"),
    FAIL(400L,"Bad Request"),
    PASSWORD_WRONG(408L,"User name or password wrong"),
    PARAM_EXCEPTION(410L,"参数异常")
    ;


    private Long code;
    private String message;

    HttpStatus(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }
}
