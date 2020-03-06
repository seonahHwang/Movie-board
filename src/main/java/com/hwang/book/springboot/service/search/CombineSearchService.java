package com.hwang.book.springboot.service.search;


import com.hwang.book.springboot.web.dto.SearchBlogDto;
import com.hwang.book.springboot.web.dto.SearchMovieDto;
import com.hwang.book.springboot.web.dto.SearchResultDto;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombineSearchService {
    private static final int LIMIT_ITEM_COUNT = 5;

    public List<SearchResultDto> combine(SearchBlogDto searchBlogDto, SearchMovieDto searchMovieDto){
        List<SearchResultDto> results = new LinkedList<SearchResultDto>();
        searchBlogDto.setItems(searchBlogDto.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
        searchMovieDto.setItems(searchMovieDto.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
        results.add(searchBlogDto);
        results.add(searchMovieDto);
        return results;
    }
}
