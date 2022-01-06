package com.zhu.fte.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhu.fte.biz.common.http.RestResponse;
import com.zhu.fte.biz.common.req.LoginReq;
import com.zhu.fte.biz.entity.SysUser;
import com.zhu.fte.biz.mapper.SysUserMapper;
import com.zhu.fte.biz.security.JwtAuthToken;
import com.zhu.fte.biz.service.SysMenuService;
import com.zhu.fte.biz.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhu.fte.biz.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysMenuService sysMenuService;



    @Override
    public SysUser selectByUsername(String userName) {
        return sysUserMapper.selectOne(
                new QueryWrapper<SysUser>().lambda()
                .eq(SysUser::getName,userName)
        );
    }

    @Override
    public Set<String> selectPermissionsByName(String userName) {

        return null;
    }

    @Override
    public RestResponse login(LoginReq loginReq, HttpServletRequest request) {
        String userName=loginReq.getUsername();
        String password=loginReq.getPassword();
        List<SysUser> sysUserList= sysUserMapper.selectList(new QueryWrapper<SysUser>().lambda()
            .eq(SysUser::getName,userName)
        );
        SysUser sysUser=sysUserList.size()==0?null:sysUserList.get(0);
        if(sysUser==null){
            return RestResponse.error("账户不存在");
        }
        //后续需改成密码加密处理
        if(!Objects.equals(password,sysUser.getPassword())){
            return RestResponse.error("密码错误");
        }
        JwtAuthToken token= JwtTokenUtil.login(request,userName,password,authenticationManager);
        return RestResponse.ok(token);
    }

    @Override
    public List<SysUser> getUserList(HttpServletRequest request) {
        return  sysUserMapper.selectList(new QueryWrapper<SysUser>().lambda());
    }




    @Override
    public RestResponse add(SysUser sysUser) {
        return RestResponse.ok(sysUserMapper.insert(sysUser));
    }

    @Override
    public RestResponse edit(SysUser sysUser) {
        return RestResponse.ok( sysUserMapper.updateById(sysUser));
    }

    @Override
    public RestResponse delete(int id) {
        return RestResponse.ok(sysUserMapper.deleteById(id));
    }
}
