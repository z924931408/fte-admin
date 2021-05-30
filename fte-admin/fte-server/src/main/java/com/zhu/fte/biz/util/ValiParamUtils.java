package com.zhu.fte.biz.util;

import com.zhu.fte.biz.common.exception.VerifyParamException;
import org.springframework.validation.BindingResult;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/5/29 17:11
 */
public class ValiParamUtils {
    public static void ValiParamReq(BindingResult result){
        if(result.hasErrors()){
            throw new VerifyParamException(result.getAllErrors().get(0).getDefaultMessage());
        }
    }
}
