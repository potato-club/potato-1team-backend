package com.velog.veloguser.exception;

public class AlreadyExistException extends CustomException{

    private String description;

    public AlreadyExistException(String message, String description) {
        super(message);
        this.description = description;
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
