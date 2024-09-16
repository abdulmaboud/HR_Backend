package com.trt.HR.Model.Exceptions;

public class ProjectExistsException extends Exception {
    private final String message="Project already exists";


    public ProjectExistsException() {
        super();
    }
}

