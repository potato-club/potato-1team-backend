package com.velog.veloguser.domain.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class Result<T> {

    private int code;
    private T data;
    private String message;


    public Result(int code, T data){
        this.code = code;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public static <T> Result<T> success(T data){
        return new Result(200, data);
    }

    public static Result<Object> error(int code, String message){
        return new Result(code,  message);
    }

    public static Result<Object> notFound(int code, String message){
        return new Result(code, message);
    }

}
