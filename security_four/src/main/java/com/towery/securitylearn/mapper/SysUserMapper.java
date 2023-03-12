package com.towery.securitylearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.towery.securitylearn.entity.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser selectByName(String name);
}
