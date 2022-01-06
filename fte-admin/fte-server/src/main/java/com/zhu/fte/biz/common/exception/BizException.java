package com.zhu.fte.biz.common.exception;

/**
 * 业务异常类
 *
 * @author zjq
 * @date 2022/1/6 22:35
 */
public class BizException extends RuntimeException{

    /**
     * 错误码
     */
    protected String code;

    /**
     * 错误信息
     */
    protected String message;


    public BizException() {
        super();
    }

    public BizException(BaseExceptionInterface exception){
        super(exception.getCode());
        this.code = exception.getCode();
        this.message = exception.getMsg();
    }

    public BizException(BaseExceptionInterface exception, Throwable cause){
        super(exception.getCode(),cause);
        this.code = exception.getCode();
        this.message = exception.getMsg();
    }


    public BizException(String message){
        super(message);
        this.message = message;
    }

    public BizException(String code,String message){
        super(code);
        this.code = code;
        this.message = message;
    }

    public BizException(String code, String message, Throwable cause) {
        super(code, cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return message;
    }

    public void setErrorMsg(String message) {
        this.message = message;
    }



    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
