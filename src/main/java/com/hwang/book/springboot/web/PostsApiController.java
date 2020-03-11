package com.hwang.book.springboot.web;

import com.hwang.book.springboot.config.auth.LoginUser;
import com.hwang.book.springboot.config.auth.dto.SessionUser;
import com.hwang.book.springboot.exception.BadRequestException;
import com.hwang.book.springboot.exception.ForbiddenException;
import com.hwang.book.springboot.service.posts.PostsService;
import com.hwang.book.springboot.web.dto.PostsResponseDto;
import com.hwang.book.springboot.web.dto.PostsSaveRequestDto;
import com.hwang.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //@PostAuthorize("isAuthenticated() and ( returnObject.name == principal.name )")
    //@PostAuthorize("isAuthenticated() and (  == principal. )")
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto, @LoginUser SessionUser user) {
        try {
            PostsResponseDto responseDto = postsService.findById(id);
            return postsService.update(id, requestDto);
        } catch (BadRequestException e) {
            throw new BadRequestException();
        }
    }

    @ExceptionHandler(ForbiddenException.class)
    public String forbidden() {
        return "index";
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "baaaad")
    public String bad() {
        return "error";
    }

    @GetMapping("api/error2")
    public void error2(){
        throw new BadRequestException();
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
