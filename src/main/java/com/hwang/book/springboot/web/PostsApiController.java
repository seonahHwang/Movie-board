package com.hwang.book.springboot.web;

import com.hwang.book.springboot.config.auth.LoginUser;
import com.hwang.book.springboot.config.auth.dto.SessionUser;
import com.hwang.book.springboot.service.posts.PostsService;
import com.hwang.book.springboot.web.dto.PostsResponseDto;
import com.hwang.book.springboot.web.dto.PostsSaveRequestDto;
import com.hwang.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    //@PostAuthorize("isAuthenticated() and ( returnObject.name == principal.name )")
    //@PostAuthorize("isAuthenticated() and (  == principal. )")
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto, @LoginUser SessionUser user){
        PostsResponseDto responseDto = postsService.findById(id);
//        if(responseDto.getAuthor().equals(user.getName())){
//            return postsService.update(id, requestDto);
//        }
//        else {
//            //에러처리
//            return "권한없음 ";
//        }
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
