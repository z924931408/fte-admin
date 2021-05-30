package com.zhu.fte.biz.common.http;

import com.zhu.fte.biz.common.constant.StatusEnum;
import com.zhu.fte.biz.common.enums.HttpStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/4/22 0:08
 */
@Data
public class RestResponse<T> implements Serializable {


    //执行码
    private long code;
    //消息，OK时，message一般不填
    private String msg;
    //具体数据，异常时，data不填
    private Object data;
    //时间戳，只在异常时使用
    private Date timeStamp;
    //放一些辅助信息key-value
    private Map<String,Object> info;

    public RestResponse() {
    }

    public RestResponse(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResponse(long code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 表示调用成功
     * @param data
     * @return
     */
    public static <T> RestResponse ok(T data){
        //code，msg，data
        return new RestResponse(HttpStatus.OK.code(),HttpStatus.OK.message(),data);
    }



    public static <T> RestResponse error( String message){
        //code，msg
        return new RestResponse(StatusEnum.PARAM_EXCEPTION.code(),message);
    }


}
