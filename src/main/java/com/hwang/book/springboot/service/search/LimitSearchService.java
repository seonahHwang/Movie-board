package com.hwang.book.springboot.service.search;

import com.hwang.book.springboot.web.dto.SearchBlogDto;
import com.hwang.book.springboot.web.dto.SearchMovieDto;
import com.hwang.book.springboot.web.dto.SearchResultDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

//@Service
//public class LimitSearchService {
//    private static final int LIMIT_ITEM_COUNT = 5;
//    public SearchResultDto limit(SearchResultDto searchResultDto){
//        if(searchResultDto instanceof SearchBlogDto){
//            SearchBlogDto searchBlogDto = (SearchBlogDto) searchResultDto;
//            searchBlogDto.setItems(searchBlogDto.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
//            return searchBlogDto;
//        }
//        if(searchResultDto instanceof SearchBlogDto){
//            SearchMovieDto searchMovieDto = (SearchMovieDto) searchResultDto;
//            searchMovieDto.setItems(searchMovieDto.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
//            return searchMovieDto;
//        }
//        else return searchResultDto;
//    }
//}
