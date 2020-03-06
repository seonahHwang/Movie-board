package com.hwang.book.springboot.service.search;

import com.hwang.book.springboot.web.dto.SearchMovieDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieSortService {
    public SearchMovieDto sort(SearchMovieDto searchMovieDto) {
        //movie.getItems가 list 이므로 collection의 stream생성할 때는 해당컬렉션.stream() ex) list.stream()
        Stream<SearchMovieDto.Item> movieStream = searchMovieDto.getItems().stream();
        Comparator<SearchMovieDto.Item> compare
                = Comparator.comparing((SearchMovieDto.Item i) -> i.getUserRating()).reversed();
        List sortedItems
                = movieStream.sorted(compare).filter(i -> Double.parseDouble(i.getUserRating()) > 0.0).collect(Collectors.toList());
        searchMovieDto.setItems(sortedItems);
        return searchMovieDto;
    }
}
