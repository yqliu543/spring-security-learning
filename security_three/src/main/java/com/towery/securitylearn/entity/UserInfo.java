package com.towery.securitylearn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@TableName("userinfo")
@Data
public class UserInfo extends Model<UserInfo> {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String role;
}
