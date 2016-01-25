package com.courses.java;

public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable t) {
        super(message, t);
    }
}
