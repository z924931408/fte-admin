package com.zhu.fte.biz.controller.system;


import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRole;
import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.service.SysRoleService;
import com.zhu.fte.biz.service.SysUserService;
import com.zhu.fte.biz.util.ValiParamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController  {

    @Resource
    SysRoleService sysRoleService;

    @GetMapping("/list")
    public RestResponse<List<SysRole>> getUserList(HttpServletRequest request){
        return  RestResponse.success(sysRoleService.getUserList(request)) ;
    }

    @PostMapping("/add")
    public RestResponse add(@Valid SysRole sysRole, BindingResult result){
        ValiParamUtils.ValiParamReq(result);

        sysRoleService.add(sysRole);
        return RestResponse.success(true);
    }

    @PostMapping("/delete")
    public RestResponse delete(int id){
        sysRoleService.delete(id);
        return RestResponse.success(true);
    }

    @PostMapping("/edit")
    public RestResponse edit(@Valid SysRole SysRole, BindingResult result){
        ValiParamUtils.ValiParamReq(result);
        sysRoleService.edit(SysRole);
        return RestResponse.success(true);
    }

}

