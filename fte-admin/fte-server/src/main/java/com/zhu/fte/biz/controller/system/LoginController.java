package com.zhu.fte.biz.controller.system;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.common.req.LoginReq;
import com.zhu.fte.biz.service.SysUserService;
import com.zhu.fte.biz.util.ValiParamUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author ZJQ
 * @date 2021/5/29 17:25
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/login")
    public RestResponse login( @Validated LoginReq req, BindingResult result, HttpServletRequest request){
        ValiParamUtils.ValiParamReq(result);
        return  sysUserService.login(req,request);
    }
}
