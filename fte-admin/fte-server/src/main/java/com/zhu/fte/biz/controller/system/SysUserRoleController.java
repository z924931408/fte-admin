package com.zhu.fte.biz.controller.system;


import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRoleMenu;
import com.zhu.fte.biz.entity.SysUserRole;
import com.zhu.fte.biz.service.SysRoleMenuService;
import com.zhu.fte.biz.service.SysUserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Controller
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    @Resource
    private SysUserRoleService sysUserRoleService;

    @PostMapping("/add")
    public RestResponse add(SysUserRole sysUserRole){
        return sysUserRoleService.add(sysUserRole) ;
    }


    @PostMapping("/updata")
    public RestResponse updata(SysUserRole sysUserRole){
        return sysUserRoleService.updata(sysUserRole) ;
    }

    @PostMapping("/delete")
    public RestResponse delete( String id){
        return sysUserRoleService.delete(id) ;
    }


    @GetMapping("/list")
    public RestResponse<List<SysUserRole>> list(){
        return sysUserRoleService.getList() ;
    }
}

