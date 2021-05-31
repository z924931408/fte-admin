package com.zhu.fte.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRole;
import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.mapper.SysRoleMapper;
import com.zhu.fte.biz.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getUserList(HttpServletRequest request) {
        return  sysRoleMapper.selectList(new QueryWrapper<SysRole>().lambda());
    }

    @Override
    public RestResponse add(SysRole sysRole) {
            return RestResponse.ok(sysRoleMapper.insert(sysRole));
    }

    @Override
    public RestResponse edit(SysRole sysRole) {
        return RestResponse.ok( sysRoleMapper.updateById(sysRole));
    }

    @Override
    public RestResponse delete(int id){
        return RestResponse.ok(sysRoleMapper.deleteById(id));
    }



}
