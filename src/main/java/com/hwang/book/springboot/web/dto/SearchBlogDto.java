package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.search.Blog;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchBlogDto extends SearchResultDto {
    private int total;
    private int start;
    private int display;
    private List<Blog.Item> items;

    public SearchBlogDto(Blog blog){
        this.total = blog.getTotal();
        this.start = blog.getStart();
        this.display = blog.getDisplay();
        this.items = blog.getItems();
    }

    @Getter
    @Setter
    public static class Item {
        private String title;
        private String link;
        private String description;
        private String bloggername;
        private String bloggerlink;
    }
}
