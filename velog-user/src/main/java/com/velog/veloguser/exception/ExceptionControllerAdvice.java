package com.velog.veloguser.exception;

import com.velog.veloguser.domain.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(BAD_REQUEST)
    protected Result<Object> CustomException(BusinessException e) {
        log.error(e.getMessage(), e);
        return Result.error(BAD_REQUEST.value(), e.getMessage());
    }


    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(BAD_REQUEST)
    protected Result<Object> AlreadyExistException(AlreadyExistException e) {
        log.error(e.getMessage(), e);
        return Result.error(BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    protected Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String field = e.getBindingResult().getFieldError() == null ? "" : e.getBindingResult().getFieldError().getField();
        return Result.error(BAD_REQUEST.value(), String.format("%s - %s", field, e.getBindingResult().getFieldError().getDefaultMessage()));
    }
}
