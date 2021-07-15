package com.velog.veloguser.exception;

import com.velog.veloguser.domain.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(CustomException.class)
    protected Result<Object> CustomException(CustomException e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }


    @ExceptionHandler(AlreadyExistException.class)
    protected Result<Object> AlreadyExistException(AlreadyExistException e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String field = e.getBindingResult().getFieldError() == null ? "" : e.getBindingResult().getFieldError().getField();
        return Result.error(String.format("%s - %s", field, e.getBindingResult().getFieldError().getDefaultMessage()));
    }
}
