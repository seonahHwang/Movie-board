package com.hwang.book.springboot.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="forbidden")
public class ForbiddenException extends RuntimeException {
    private String message;
    private String reason;
    public ForbiddenException(String message){
        this.message = message;
    }
}
