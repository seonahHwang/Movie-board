package com.hwang.book.springboot.config.profile;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value="develop")
@Getter
@PropertySource({"classpath:develop/application.properties"})
public class ProfileDevelop {
    @Value("${naver.openapi.blog-url}")
    private String blogUrl;
    @Value("${naver.openapi.movie-url}")
    private String movieUrl;
    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String clientSecret;
}