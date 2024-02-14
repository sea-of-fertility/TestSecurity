package com.example.testsecurity.exception.join;

public class DuplicateUser extends RuntimeException{

    public DuplicateUser(String message) {
        super(message);
    }

    public DuplicateUser(String message, Throwable cause) {
        super(message, cause);
    }
}
