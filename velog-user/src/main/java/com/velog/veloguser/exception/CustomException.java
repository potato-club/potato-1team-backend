package com.velog.veloguser.exception;

public class CustomException extends RuntimeException{

    private String description;

    public CustomException(String message, String description) {
        super(message);
        this.description = description;
    }

    public CustomException(String message) {
        super(message);
    }

}
