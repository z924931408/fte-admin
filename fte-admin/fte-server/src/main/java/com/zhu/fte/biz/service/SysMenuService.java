package com.zhu.fte.biz.service;

import com.zhu.fte.biz.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getUser(String userName);

}