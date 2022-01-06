package com.zhu.fte.biz.common.exception;

/**
 * 异常基础接口类
 *
 * @author zjq
 * @date 2022/1/6 22:31
 */
public interface BaseExceptionInterface {

    /**
     * 错误码
     * @return
     */
    String getCode();


    /**
     * 错误描述
     * @return
     */
    String getMsg();

}
