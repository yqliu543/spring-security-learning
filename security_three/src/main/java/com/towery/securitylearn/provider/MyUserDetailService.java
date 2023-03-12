package com.towery.securitylearn.provider;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.towery.securitylearn.entity.UserInfo;
import com.towery.securitylearn.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userinfo;
        User user=null;
        if (username != null) {
            userinfo=userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUsername,username));
            List<GrantedAuthority> list = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userinfo.getRole());
            list.add(authority);
            user = new User(userinfo.getUsername(),userinfo.getPassword(),list);
        }
        return user;
    }
}
