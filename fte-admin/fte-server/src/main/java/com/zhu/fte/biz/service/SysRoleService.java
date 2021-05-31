package com.zhu.fte.biz.service;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhu.fte.biz.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> getUserList(HttpServletRequest request);



    RestResponse add(SysRole sysRole);

    RestResponse edit(SysRole sysRole);


    RestResponse delete(int id);
}
