package com.zhu.fte.biz.common.exception;

import com.zhu.fte.biz.common.enums.HttpStatus;
import com.zhu.fte.biz.common.http.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常统一处理
 *
 * @author zjq
 * @date 2022/1/6 22:24
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public RestResponse bizExceptionHandler(HttpServletRequest req,BizException e){
        log.error("发生业务异常！原因是"+e.getErrorMsg());
        return RestResponse.error(e.code,e.getMessage());
    }


    /**
     * 处理空指针异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public RestResponse exceptionHandler(HttpServletRequest req,NullPointerException e){
        log.error("发生业务异常！原因是"+e);
        return RestResponse.error(HttpStatus.BODY_NOT_MATCH);
    }



    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponse exceptionHandler(HttpServletRequest req,Exception e){
        log.error("发生业务异常！原因是"+e);
        return RestResponse.error(HttpStatus.BODY_NOT_MATCH);
    }


}
