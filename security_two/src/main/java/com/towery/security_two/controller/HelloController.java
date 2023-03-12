package com.towery.security_two.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/world")
    public String sayhello() {
        return "安全框架访问成功！";
    }
}
