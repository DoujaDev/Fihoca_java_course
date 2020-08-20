package org.eduware.seguros.controllers.excepetionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionPojo> handle(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ExceptionPojo(666,e.getMessage()));
    }  
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleClassCastException(Exception e) {
       
        return ResponseEntity
                .status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                .body("Booooom!");
    }   
    
	/*
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionPojo> handleGenericException(IllegalArgumentException e) {
       
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ExceptionPojo(e.hashCode(),e.getMessage()));
    } 
	*/
	
	
	
}
