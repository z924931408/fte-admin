package com.zhu.fte.biz.controller.system;


import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysMenu;
import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.service.SysMenuService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author ZQJ
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    @GetMapping("/list")
    public RestResponse<List<SysMenu>> list(){
        return RestResponse.ok(sysMenuService.getMenus()) ;
    }

    @PostMapping("/add")
    public RestResponse add(SysMenu sysMenu){
        return sysMenuService.add(sysMenu) ;
    }

    @PostMapping("/updata")
    public RestResponse updata(SysMenu sysMenu){
        return sysMenuService.updata(sysMenu) ;
    }

    @PostMapping("/delete")
    public RestResponse delete(String id){
        return sysMenuService.delete(id) ;
    }

}

