package com.hwang.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//수정
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String movie_title;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String movie_title) {
        this.title = title;
        this.content = content;
        this.movie_title = movie_title;
    }
}