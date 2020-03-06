package com.hwang.book.springboot.service.search;

import com.hwang.book.springboot.SearchProperties;
import com.hwang.book.springboot.domain.search.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final RestTemplate restTemplate;
    private final SearchProperties searchProperties;

    public Result search(String url, String query, Class<? extends Result> resultType){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", searchProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", searchProperties.getClientSecret());
        String searchUrl = url + "?query=" + query;
        Result result = restTemplate.exchange(searchUrl, HttpMethod.GET, new HttpEntity(httpHeaders),
                resultType).getBody();
        return result;
    }
}
