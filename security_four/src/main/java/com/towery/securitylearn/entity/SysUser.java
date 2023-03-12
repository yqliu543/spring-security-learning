package com.towery.securitylearn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@TableName("sys_user")
public class SysUser extends Model<SysUser> implements UserDetails  {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("realname")
    private String realname;
    @TableField("isexpired")
    private boolean isExpired;
    @TableField("islock")
    private boolean islLocked;
    @TableField("iscredentials")
    private boolean isCredentials;
    @TableField("isenable")
    private boolean isenabled;
    @TableField("createtime")
    private Date createtime;
    @TableField("logintime")
    private Date logintime;
    private List <GrantedAuthority> authorities;

    public SysUser() {
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return password;
    }


    public Long getId() {
        return id;
    }

    public String getRealname() {
        return realname;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public boolean isIslLocked() {
        return islLocked;
    }

    public boolean isCredentials() {
        return isCredentials;
    }

    public boolean isIsenabled() {
        return isenabled;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public Date getLogintime() {
        return logintime;
    }


    public boolean isAccountNonExpired() {
        return isExpired;
    }


    public boolean isAccountNonLocked() {
        return islLocked;
    }


    public boolean isCredentialsNonExpired() {
        return isCredentials;
    }


    public boolean isEnabled() {
        return isenabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public void setIslLocked(boolean islLocked) {
        this.islLocked = islLocked;
    }

    public void setCredentials(boolean credentials) {
        isCredentials = credentials;
    }

    public void setIsenabled(boolean isenabled) {
        this.isenabled = isenabled;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
