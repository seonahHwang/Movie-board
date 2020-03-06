package com.hwang.book.springboot.web;

import com.hwang.book.springboot.SearchProperties;
import com.hwang.book.springboot.domain.search.Blog;
import com.hwang.book.springboot.domain.search.Movie;
import com.hwang.book.springboot.service.search.CombineSearchService;
import com.hwang.book.springboot.service.search.MovieSortService;
import com.hwang.book.springboot.service.search.SearchService;
import com.hwang.book.springboot.web.dto.SearchBlogDto;
import com.hwang.book.springboot.web.dto.SearchMovieDto;
import com.hwang.book.springboot.web.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
//@RestController
@RequestMapping("/api")
public class SearchController {
    private final SearchService searchService;
    private final CombineSearchService combineSearchService;
    private final MovieSortService movieSortService;
    private final SearchProperties searchProperties;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/search")
    public List<SearchResultDto> search(@RequestParam(name = "query") String query){
        Blog blog = (Blog) searchService.search(searchProperties.getBlogUrl(), query, Blog.class);
        SearchBlogDto SearchBlogDto = new SearchBlogDto(blog);
        Movie movie = (Movie) searchService.search(searchProperties.getMovieUrl(), query, Movie.class);
        SearchMovieDto SearchMovieDto = new SearchMovieDto(movie);
        return combineSearchService.combine(SearchBlogDto,movieSortService.sort(SearchMovieDto));
    }

    @GetMapping("/blog")
    public String  blogSearch(Model model, @RequestParam(name = "query") String query){
        Blog blog = (Blog) searchService.search(searchProperties.getBlogUrl(), query, Blog.class);
        SearchBlogDto SearchBlogDto = new SearchBlogDto(blog);
        model.addAttribute("blogItems",SearchBlogDto.getItems());
        return "index";
    }

    @GetMapping("/movie")
    public SearchMovieDto movieSearch(@RequestParam(name = "query") String query){
        Movie movie = (Movie) searchService.search(searchProperties.getMovieUrl(), query, Movie.class);
        SearchMovieDto SearchMovieDto = new SearchMovieDto(movie);
        return movieSortService.sort(SearchMovieDto);
    }
}