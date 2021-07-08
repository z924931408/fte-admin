package com.zhu.fte.biz.service.impl;

import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.entity.SysRoleMenu;
import com.zhu.fte.biz.mapper.SysRoleMenuMapper;
import com.zhu.fte.biz.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色机构表 服务实现类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public RestResponse add(SysRoleMenu sysRoleMenu) {
        return RestResponse.ok(sysRoleMenuMapper.insert(sysRoleMenu));
    }

    @Override
    public RestResponse updata(SysRoleMenu sysRoleMenu) {
        return RestResponse.ok(sysRoleMenuMapper.updateById(sysRoleMenu));
    }

    @Override
    public RestResponse delete(String id) {
        return RestResponse.ok(sysRoleMenuMapper.deleteById(id));
    }

    @Override
    public RestResponse<List<SysRoleMenu>> getList() {
        return RestResponse.ok(sysRoleMenuMapper.selectList(null));
    }
}
