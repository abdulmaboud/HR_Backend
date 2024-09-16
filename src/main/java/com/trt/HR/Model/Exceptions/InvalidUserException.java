package com.trt.HR.Model.Exceptions;

public class InvalidUserException extends Exception {
    private final String message="Invalid username or password";


    public InvalidUserException() {
        super();
    }
}
