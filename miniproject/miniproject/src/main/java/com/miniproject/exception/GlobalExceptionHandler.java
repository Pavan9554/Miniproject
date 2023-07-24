package com.miniproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice//it acts like a catch block ,what ever the exception occurred in controller layer it comes to @ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //Specific Exception
    @ExceptionHandler(ResourceNotFoundException.class)//From were the exception will occur that object adders will inject to this ExceptionHandler
    public ResponseEntity<com.myblog.blogapp.payloadorDTO.ErrorDetails> handleResourceNotFoundException (ResourceNotFoundException exception, WebRequest webRequest){
//       ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        com.myblog.blogapp.payloadorDTO.ErrorDetails errorDetails = new com.myblog.blogapp.payloadorDTO.ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //Global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.myblog.blogapp.payloadorDTO.ErrorDetails> handleGlobalException (Exception exception, WebRequest webRequest){
//       ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        com.myblog.blogapp.payloadorDTO.ErrorDetails errorDetails = new com.myblog.blogapp.payloadorDTO.ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
