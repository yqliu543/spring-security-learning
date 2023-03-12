package com.towery.securitylearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControoler {
    @GetMapping("/index")
    public String reduction(){
        return "forward:/index.html";
    }
}
