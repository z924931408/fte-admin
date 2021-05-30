package com.zhu.fte.biz.controller.system;


import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.common.req.LoginReq;
import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.service.SysUserService;
import com.zhu.fte.biz.util.ValiParamUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    SysUserService sysUserService;

    @GetMapping("/list")
    public  RestResponse<List<SysUser>> getUserList(HttpServletRequest request){
        return  RestResponse.ok(sysUserService.getUserList(request)) ;
    }

    @PostMapping("/add")
    public RestResponse add( @Valid SysUser sysUser, BindingResult result){
        ValiParamUtils.ValiParamReq(result);
        return sysUserService.add(sysUser);
    }

    @PostMapping("/delete")
    public RestResponse delete(int id){
        return sysUserService.delete(id);
    }

    @PostMapping("/edit")
    public RestResponse edit(@Valid SysUser sysUser, BindingResult result){
        ValiParamUtils.ValiParamReq(result);
        return sysUserService.edit(sysUser);
    }

}

