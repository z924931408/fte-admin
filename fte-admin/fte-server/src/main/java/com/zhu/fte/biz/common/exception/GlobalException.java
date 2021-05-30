package com.zhu.fte.biz.common.exception;

import com.zhu.fte.biz.common.constant.Status;
import lombok.Data;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/5/29 17:13
 */
@Data
public class GlobalException extends RuntimeException{

    private Status status;

    public GlobalException() {
        super();
    }

    public GlobalException(Status status) {
        super(status.toString());
        this.status = status;
    }

    public GlobalException( Status status,Throwable cause) {
        super(status.toString(), cause);
        this.status = status;
    }

    public GlobalException( Status status,String message, Throwable cause) {
        super(String.format("%s\t%s",status.toString(),message),cause);
        this.status = status;
    }

    public String errorMsg(){
        return this.getStatus().message();
    }
}
