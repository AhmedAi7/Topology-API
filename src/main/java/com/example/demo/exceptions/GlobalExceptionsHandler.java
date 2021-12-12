package com.example.demo.exceptions;

import com.example.demo.payload.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionsHandler {
@ExceptionHandler(ArrayStoreException.class)
public final ResponseEntity<ErrorMessage> handleStoreinArrayExceptions(ArrayStoreException ex) {
    Map<String, String> error=new HashMap<>();
    error.put("Error",ex.getMessage());
    ErrorMessage errorDetails = new ErrorMessage(new Date(),error);
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(FileNotFoundException.class)
public final ResponseEntity<ErrorMessage> handleFileNotFoundException(FileNotFoundException ex) {
    Map<String, String> error=new HashMap<>();
    error.put("Error",ex.getMessage());
    ErrorMessage errorDetails = new ErrorMessage(new Date(),error);
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(NullPointerException.class)
public final ResponseEntity<ErrorMessage> handleNullPointerException(NullPointerException ex) {
    Map<String, String> error=new HashMap<>();
    error.put("Error",ex.getMessage());
    ErrorMessage errorDetails = new ErrorMessage(new Date(),error);
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
}
}
