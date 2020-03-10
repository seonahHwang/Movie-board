package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

//조회화면에서 보여줄 내용
@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String movie_title;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.movie_title = entity.getMovie_title();
        this.modifiedDate = entity.getModifiedDate();
    }
}
