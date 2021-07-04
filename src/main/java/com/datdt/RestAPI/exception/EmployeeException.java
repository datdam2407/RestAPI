package com.datdt.RestAPI.exception;

public class EmployeeException extends RuntimeException {
    public EmployeeException(Long employeeID) {
        super("Could Not Find Employee " + employeeID);
    }
}
