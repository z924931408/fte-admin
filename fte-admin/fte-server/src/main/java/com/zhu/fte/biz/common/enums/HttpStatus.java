package com.zhu.fte.biz.common.enums;

import com.zhu.fte.biz.common.exception.BaseExceptionInterface;
import org.springframework.util.StringUtils;

public enum HttpStatus  implements BaseExceptionInterface {
    OK("200","OK"),
    NOT_FOUND("404", "未找到该资源!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!")
    ;

    private String code;


    private String msg;



    HttpStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }


}
