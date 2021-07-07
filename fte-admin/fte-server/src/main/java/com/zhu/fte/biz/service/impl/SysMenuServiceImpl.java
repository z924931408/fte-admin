package com.zhu.fte.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.util.StringUtils;
import com.zhu.fte.biz.common.constant.Constants;
import com.zhu.fte.biz.entity.SysMenu;
import com.zhu.fte.biz.mapper.SysMenuMapper;
import com.zhu.fte.biz.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ZQJ
 * @since 2021-07-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getUser(String userName) {
        if(StringUtils.isNullOrEmpty(userName)|| Constants.ADMIN.equalsIgnoreCase(userName)){
            return sysMenuMapper.selectList(new QueryWrapper<SysMenu>().lambda());
        }
        return sysMenuMapper.selectList(null);

    }

    @Override
    public List<SysMenu> getMenus() {
        return sysMenuMapper.selectList(null);
    }
}
