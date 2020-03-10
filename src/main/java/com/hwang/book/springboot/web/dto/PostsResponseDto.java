package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.posts.Posts;
import lombok.Getter;
//db에서 select해서 반환할 때
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String movie_title;

    public PostsResponseDto(Posts Entity){
        this.id = Entity.getId();
        this.title = Entity.getTitle();
        this.content = Entity.getContent();
        this.author = Entity.getAuthor();
        this.movie_title = Entity.getMovie_title();
    }

}
