package com.zhu.fte.biz.service;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色机构表 服务类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {


    RestResponse add(SysRoleMenu sysRoleMenu);

    RestResponse updata(SysRoleMenu sysRoleMenu);

    RestResponse delete(String id);


    RestResponse<List<SysRoleMenu>> getList();


}
