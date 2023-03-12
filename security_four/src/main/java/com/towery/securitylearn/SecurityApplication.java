package com.towery.securitylearn;

import com.towery.securitylearn.entity.SysUser;
import com.towery.securitylearn.mapper.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@MapperScan("com.towery.securitylearn.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SecurityApplication {
    @Autowired
    private SysUserMapper userMapper;
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
//    @PostConstruct
    public void init(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + "RW");
        list.add(authority);
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword(encoder.encode("123456"));
        sysUser.setRealname("admin");
        sysUser.setIslLocked(true);
        sysUser.setIsenabled(true);
        sysUser.setCredentials(true);
        sysUser.setExpired(true);
        sysUser.setLogintime(new Date());
        sysUser.setCreatetime(new Date());
//        sysUser.setAuthorities(list);
        SysUser u = new SysUser();
        u.setUsername("ls");
        u.setPassword(encoder.encode("123456"));
        u.setRealname("李四");
        u.setIslLocked(true);
        u.setIsenabled(true);
        u.setCredentials(true);
        u.setExpired(true);
        u.setLogintime(new Date());
        u.setCreatetime(new Date());
//        userMapper.insert(sysUser);
        userMapper.insert(u);
    }
}
