package com.towery.securitylearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.towery.securitylearn.entity.SysRole;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {
List<SysRole> selectRoleByUser(Long userid);
}
