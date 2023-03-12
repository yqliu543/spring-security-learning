package com.towery.securitylearn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/world")
    @PreAuthorize("hasAnyRole('1')")
    public String sayhello() {
        return "1权限可以安全框架访问成功！";
    }
    @RequestMapping("/world2")
    @PreAuthorize("hasAnyRole('2')")
    public String sayhello2() {
        return "2权限可以安全框架访问成功！";
    }
}
