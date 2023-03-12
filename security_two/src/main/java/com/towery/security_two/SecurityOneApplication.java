package com.towery.security_two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SecurityOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOneApplication.class, args);
    }

}
