package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.search.Blog;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class SearchBlogDto extends SearchResultDto {
    private int total;
    private int start;
    private int display;
    private List<SearchBlogDto.Item> items;

    public SearchBlogDto(Blog blog) {
        this.total = blog.getTotal();
        this.start = blog.getStart();
        this.display = blog.getDisplay();
        List<Blog.Item> li = blog.getItems();
        this.items = new LinkedList<SearchBlogDto.Item>();
        li.forEach(i -> this.items.add(new Item(i)));
    }

    @Getter
    @Setter
    public static class Item {
        private String title;
        private String link;
        private String description;
        private String bloggername;
        private String bloggerlink;

        public Item(Blog.Item item) {
            this.title = item.getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.title = this.title.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.link = item.getLink().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.description = item.getDescription().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.description = this.description.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.bloggername = item.getBloggername().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.bloggername = this.bloggername.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.bloggerlink = item.getBloggerlink().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.bloggerlink = this.bloggerlink.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
        }
    }

}
