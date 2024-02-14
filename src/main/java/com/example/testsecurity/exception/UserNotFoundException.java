package com.example.testsecurity.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "가입되지 않은 이름입니다.";

    public UserNotFoundException() {
        super(MESSAGE);
    }

    public UserNotFoundException(String MESSAGE, Throwable cause) {
        super(MESSAGE, cause);
    }
}
