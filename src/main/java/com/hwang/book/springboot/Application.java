package com.hwang.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
@SpringBootApplication
public class Application { //메인클래스, 내장 WAS 실행
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
