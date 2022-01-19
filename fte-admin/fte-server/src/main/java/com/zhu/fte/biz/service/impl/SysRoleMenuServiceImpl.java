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
    public void add(SysRoleMenu sysRoleMenu) {
         sysRoleMenuMapper.insert(sysRoleMenu);
    }

    @Override
    public void updata(SysRoleMenu sysRoleMenu) {
        sysRoleMenuMapper.updateById(sysRoleMenu);
    }

    @Override
    public void delete(String id) {
        sysRoleMenuMapper.deleteById(id);
    }

    @Override
    public List<SysRoleMenu> getList() {
        return sysRoleMenuMapper.selectList(null);
    }
}
