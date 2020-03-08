package com.hwang.book.springboot;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

//
@SpringBootApplication
public class Application { //메인클래스, 내장 WAS 실행
    static ApplicationContext ctx;
    public static void main(String[] args) {
        String profile = System.getProperty("spring.profiles.active");
        if(profile == null) {
            System.setProperty("spring.profiles.active", "develop");
        }
        SpringApplication.run(Application.class,args);
    }
}
