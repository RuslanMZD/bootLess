package com.example.question.exception;

public class NotFoundProfileException extends RuntimeException {

    public NotFoundProfileException(Long id) {
        super("Not found Profile with id " + id );
    }
}
