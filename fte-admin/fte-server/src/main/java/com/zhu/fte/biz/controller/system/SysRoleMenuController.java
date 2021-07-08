package com.zhu.fte.biz.controller.system;


import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysMenu;
import com.zhu.fte.biz.entity.SysRoleMenu;
import com.zhu.fte.biz.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色机构表 前端控制器
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Controller
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @PostMapping("/add")
    public RestResponse add(SysRoleMenu sysRoleMenu){
        return sysRoleMenuService.add(sysRoleMenu) ;
    }


    @PostMapping("/updata")
    public RestResponse updata(SysRoleMenu sysRoleMenu){
        return sysRoleMenuService.updata(sysRoleMenu) ;
    }

    @PostMapping("/delete")
    public RestResponse delete( String id){
        return sysRoleMenuService.delete(id) ;
    }


    @GetMapping("/list")
    public RestResponse<List<SysRoleMenu>> list(){
        return sysRoleMenuService.getList() ;
    }

}

