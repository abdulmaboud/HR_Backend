package com.trt.HR.Model.Exceptions;

public class ExistUserException  extends Exception {
    private final String message="Username is taken ,choose another username";


    public ExistUserException() {
        super();
    }
}

