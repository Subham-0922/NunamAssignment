package com.nunam.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


//Annotating this class as a Controller Advice to handle exceptions globally
@ControllerAdvice
public class GlobalExceptionHandler {
 
 // Exception handler method for handling custom AllException
 @ExceptionHandler(AllException.class)
 public ResponseEntity<MyExceptionHandler> myExpHandler(AllException ie, WebRequest req) {
     System.out.println("Inside myHandler method...");

     // Create a ResponseEntity with a custom MyExceptionHandler object and HTTP status BAD_REQUEST
     return new ResponseEntity<MyExceptionHandler>(
         new MyExceptionHandler(LocalDateTime.now(), ie.getMessage(), req.getDescription(false)),
         HttpStatus.BAD_REQUEST
     );
 }
}