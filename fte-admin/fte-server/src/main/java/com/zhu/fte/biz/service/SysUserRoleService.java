package com.zhu.fte.biz.service;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRoleMenu;
import com.zhu.fte.biz.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    void add(SysUserRole sysUserRole);

    void updata(SysUserRole sysUserRole);

    void delete(String id);


    List<SysUserRole> getList();

}
