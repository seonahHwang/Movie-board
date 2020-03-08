package com.hwang.book.springboot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Getter
//@Configuration
//@PropertySource(class)
//public class SearchProperties{
//    @Value("#{application['naver.openapi.blog-url']}")
//    private String blogUrl;
//    @Value("#{application['naver.openapi.movie-url']}")
//    private String movieUrl;
//    @Value("#{application['spring.security.oauth2.client.registration.naver.client-id']}")
//    private String clientId;
//    @Value("#{application['spring.security.oauth2.client.registration.naver.client-secret']}")
//    private String clientSecret;
//}