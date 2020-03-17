package com.hwang.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application { //메인클래스, 내장 WAS 실행
    public static void main(String[] args) {
        String profile = System.getProperty("spring.profiles.active");
//        System.out.println("=======profile:"+profile);
//        if(profile == null) {
//            System.setProperty("spring.profiles.active", "develop");
//        }
        SpringApplication.run(Application.class,args);
    }
}
