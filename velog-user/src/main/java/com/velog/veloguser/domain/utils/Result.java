package com.velog.veloguser.domain.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private T data;
    private String message;


    public static <T> Result<T> success(T data){
        return new Result(data, null);
    }

    public static Result<Object> error(String message){
        return new Result(null, message);
    }

    public static Result<Object> notFound(HttpStatus status, String message){
        return new Result(null, message);
    }

}
