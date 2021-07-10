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
    public RestResponse add(SysUserRole sysUserRole) {
        return RestResponse.ok( sysUserRoleMapper.insert(sysUserRole));
    }

    @Override
    public RestResponse updata(SysUserRole sysUserRole) {
        return RestResponse.ok(sysUserRoleMapper.updateById(sysUserRole));
    }

    @Override
    public RestResponse delete(String id) {
        return RestResponse.ok(sysUserRoleMapper.deleteById(id));
    }

    @Override
    public RestResponse<List<SysUserRole>> getList() {
        return RestResponse.ok(sysUserRoleMapper.selectList(null));
    }
}
