package com.zhu.fte.biz.service;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.common.req.LoginReq;
import com.zhu.fte.biz.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
public interface SysUserService extends IService<SysUser> {

    SysUser selectByUsername(String userName);

    Set<String> selectPermissionsByName(String userName);

    /**
     * 登陆
     * @param req
     * @param request
     * @return
     */
    RestResponse login(LoginReq req, HttpServletRequest request);


    List<SysUser> getUserList(HttpServletRequest request);



    RestResponse add(SysUser sysUser);

    RestResponse edit(SysUser sysUser);


    RestResponse delete(int id);



}
