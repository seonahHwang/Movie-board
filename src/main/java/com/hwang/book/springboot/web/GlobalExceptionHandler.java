package com.hwang.book.springboot.web;

import com.hwang.book.springboot.exception.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason="forbidden")
    public void forbiddenException(ForbiddenException ex,
                                HttpServletResponse response) { //에러 발생하면 어떻게 처리할지?
        System.out.println("권한이 없습니다");
        System.out.println(ex.getMessage());
    }
}
