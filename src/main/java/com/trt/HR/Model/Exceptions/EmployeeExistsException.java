package com.trt.HR.Model.Exceptions;

public class EmployeeExistsException extends Exception{


    private final String message="Employee already exists";


    public EmployeeExistsException() {
        super();
    }
}

