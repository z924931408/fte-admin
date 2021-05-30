package com.zhu.fte.biz.common.exception;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/5/29 17:13
 */
public class VerifyParamException extends GlobalException{
    //提示错误信息
    private String msg;

    public VerifyParamException(String msg){
        super();
    }
}
