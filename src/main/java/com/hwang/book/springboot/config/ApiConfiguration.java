package com.hwang.book.springboot.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableConfigurationProperties({SearchProperties.class})
@Configuration
public class ApiConfiguration {
    @Bean //restTemplate를 bean으로 관리하기 위해서 Config에 bean으로 등록해줌
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory
                = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10*1000); //timeout 설정
        factory.setReadTimeout(10*1000);
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100) // 최대 커넥션 갯수
                .setMaxConnPerRoute(5) // IP/domain name당 최대 커넥션 갯수
                .build();
        factory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}
