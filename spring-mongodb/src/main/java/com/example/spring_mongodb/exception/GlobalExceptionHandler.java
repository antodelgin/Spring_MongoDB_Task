package com.example.spring_mongodb.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//Global exception handler to manage application-wide exceptions

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handles EmployeeNotFoundException
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEmployeeNotFoundException(EmployeeNotFoundException exception, Model model) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error";
    }

    //Handles general exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGlobalException(Exception exception, Model model) {
        model.addAttribute("errorMessage", "An unexpected error occurred: " + exception.getMessage());
        return "error";
    }
}

