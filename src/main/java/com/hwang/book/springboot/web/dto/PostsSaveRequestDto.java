package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//저장
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String movie_title;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, String movie_title){
        this.title = title;
        this.content = content;
        this.author = author;
        this.movie_title = movie_title;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .movie_title(movie_title)
                .build();
    }
}
