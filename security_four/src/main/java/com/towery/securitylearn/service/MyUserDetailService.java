package com.towery.securitylearn.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.towery.securitylearn.entity.SysRole;
import com.towery.securitylearn.entity.SysUser;
import com.towery.securitylearn.mapper.SysRoleMapper;
import com.towery.securitylearn.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (sysUser!=null){
            List<SysRole> rolelists = sysRoleMapper.selectRoleByUser(sysUser.getId());
            ArrayList<GrantedAuthority> list = new ArrayList<>();
            for (SysRole role:rolelists) {
                String rolename = role.getRolename();
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+rolename);
                list.add(authority);
            }
            sysUser.setAuthorities(list);
        }
        return sysUser;
    }
}
