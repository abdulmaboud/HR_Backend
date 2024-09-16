package com.trt.HR.Model.Exceptions;

public class EmployeeDoesNotExistException extends Exception{



    private final String message="Employee Doesn't exists";


    public EmployeeDoesNotExistException() {
        super();
    }
}

