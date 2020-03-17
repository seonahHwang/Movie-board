package com.hwang.book.springboot.service.search;

import com.hwang.book.springboot.config.profile.ProfileDevelop;
import com.hwang.book.springboot.config.profile.ProfileReal;
import com.hwang.book.springboot.domain.search.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final RestTemplate restTemplate;
    private final ProfileDevelop developProperties;

    public Result search(String url, String query, Class<? extends Result> resultType){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", developProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", developProperties.getClientSecret());
        String searchUrl = url + "?query=" + query;
        Result result = restTemplate.exchange(searchUrl, HttpMethod.GET, new HttpEntity(httpHeaders),
                resultType).getBody();
        String profile = System.getProperty("spring.profiles.active");
        System.out.println("=======profile:"+profile);
        System.out.println("============develop");
        return result;
    }
}
