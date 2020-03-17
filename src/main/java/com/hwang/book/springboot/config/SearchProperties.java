package com.hwang.book.springboot.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class SearchProperties {
    @Value("${naver.openapi.blog-url}")
    private String blogUrl;
    @Value("${naver.openapi.movie-url}")
    private String movieUrl;
    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String clientSecret;
}
