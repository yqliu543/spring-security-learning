package com.towery.securitylearn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class HelloController {
    @RequestMapping("/user")
//    @PreAuthorize("hasAnyRole('1')")
    public String sayhello() {
        return "普通角色权限可以安全框架访问成功！";
    }
    @RequestMapping("/read")
//    @PreAuthorize("hasAnyRole('2')")
    public String sayhello2() {
        return "读权限可以安全框架访问成功！";
    }
    @RequestMapping("/admin")
    public String sayhello3() {
        return "管理员权限可以安全框架访问成功！";
    }
}
