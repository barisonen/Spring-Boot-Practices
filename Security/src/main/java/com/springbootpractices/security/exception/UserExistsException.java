package com.springbootpractices.security.exception;

public class UserExistsException extends Exception {

    public UserExistsException(String message) {
        super(message);
    }
}
