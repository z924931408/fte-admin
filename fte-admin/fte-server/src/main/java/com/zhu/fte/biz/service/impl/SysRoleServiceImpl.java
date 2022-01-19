package com.zhu.fte.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRole;
import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.entity.SysUserRole;
import com.zhu.fte.biz.mapper.SysRoleMapper;
import com.zhu.fte.biz.mapper.SysUserRoleMapper;
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
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getUserList(HttpServletRequest request) {
        return  sysRoleMapper.selectList(new QueryWrapper<SysRole>().lambda());
    }

    @Override
    public void add(SysRole sysRole) {
            sysRoleMapper.insert(sysRole);
    }

    @Override
    public void edit(SysRole sysRole) {
        sysRoleMapper.updateById(sysRole);
    }

    @Override
    public void delete(int id){
        sysUserRoleMapper.delete(new QueryWrapper<SysUserRole>().lambda().eq(SysUserRole::getRoleId,id));
        sysRoleMapper.deleteById(id);
    }



}
