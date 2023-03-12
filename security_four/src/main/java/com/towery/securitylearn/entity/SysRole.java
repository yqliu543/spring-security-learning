package com.towery.securitylearn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("sys_role")
public class SysRole extends Model<SysRole> {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String rolename;
    private String rolememo;
}
