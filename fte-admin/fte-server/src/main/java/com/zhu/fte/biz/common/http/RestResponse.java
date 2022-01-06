package com.zhu.fte.biz.common.http;

import com.zhu.fte.biz.common.enums.HttpStatus;
import com.zhu.fte.biz.common.exception.BaseExceptionInterface;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应数据结构
 *
 * @author ZJQ
 * @date 2021/4/22 0:08
 */
@Data
public class RestResponse<T> implements Serializable {

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;


    /**
     * 响应结果
     */
    private T result;


    public RestResponse() {
    }

    public RestResponse(BaseExceptionInterface errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMsg();
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static RestResponse success(Object data){
        RestResponse res = new RestResponse();
        res.setCode(HttpStatus.OK.getCode());
        res.setMessage(HttpStatus.OK.getMsg());
        res.setResult(data);
        return res;
    }

    /**
     * 失败
     * @param exception
     * @return
     */
    public static RestResponse error(BaseExceptionInterface exception){
        RestResponse res = new RestResponse();
        res.setCode(exception.getCode());
        res.setMessage(exception.getMsg());
        res.setResult(null);
        return res;
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     */
    public static RestResponse error(String code ,String message){
        RestResponse res = new RestResponse();
        res.setCode(code);
        res.setMessage(message);
        res.setResult(null);
        return res;
    }




}
