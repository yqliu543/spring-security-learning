package com.towery.securitylearn.init;

import com.towery.securitylearn.entity.UserInfo;
import com.towery.securitylearn.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JDBCInit {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @PostConstruct
    public void init(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("ww");
        userInfo.setPassword(encoder.encode("123456"));
        userInfo.setRole("1");
        userInfoMapper.insert(userInfo);
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUsername("ss");
        userInfo2.setPassword(encoder.encode("123456"));
        userInfo2.setRole("2");
        userInfoMapper.insert(userInfo2);
    }
}
