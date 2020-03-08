package com.hwang.book.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//profile 확인
@RestController
public class ProfileController {
    @Autowired
    private Environment environment;

    @GetMapping("/ping")
    public String ping() {
        String[] env = environment.getActiveProfiles();
        return env[0];
    }
}
