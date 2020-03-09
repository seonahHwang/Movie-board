package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.search.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class SearchMovieDto extends SearchResultDto {
    private List<SearchMovieDto.Item> items;

    public SearchMovieDto(Movie movie){
        List<Movie.Item> li = movie.getItems();
        this.items = new LinkedList<Item>();
        li.forEach(i -> this.items.add(new Item(i)));
    }

    @Getter
    @Setter
    public static class Item{
        public Item(Movie.Item item){
            this.image = item.getImage();
            this.title = item.getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.title = this.title.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.link = item.getLink().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.subtitle = item.getSubtitle().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.subtitle = this.subtitle.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.pubDate = item.getPubDate().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.pubDate = this.pubDate.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.director = item.getDirector().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.director = this.director.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.actor = item.getActor().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.actor = this.actor.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
            this.userRating = item.getUserRating().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
            this.userRating = this.userRating.replaceAll("&lt(;)?(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?&gt(;)?", "");
        }
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private String pubDate;
        private String director;
        private String actor;
        private String userRating;
    }
}
