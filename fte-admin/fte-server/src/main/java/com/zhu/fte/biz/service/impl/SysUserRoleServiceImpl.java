package com.zhu.fte.biz.service.impl;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysUserRole;
import com.zhu.fte.biz.mapper.SysUserRoleMapper;
import com.zhu.fte.biz.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Resource
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public void add(SysUserRole sysUserRole) {
        sysUserRoleMapper.insert(sysUserRole);

    }

    @Override
    public void updata(SysUserRole sysUserRole) {
        sysUserRoleMapper.updateById(sysUserRole);
    }

    @Override
    public void delete(String id) {
        sysUserRoleMapper.deleteById(id);
    }

    @Override
    public List<SysUserRole> getList() {
        return sysUserRoleMapper.selectList(null);
    }
}
