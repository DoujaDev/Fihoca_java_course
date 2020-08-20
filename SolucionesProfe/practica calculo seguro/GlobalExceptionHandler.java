package com.pgrsoft.carinsurance.controllers.exceptionshandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<PatitoGoma> handleArithmeticException(Exception e) {
      
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(new PatitoGoma("rufus","pato simpatico"));
    }  
	
	@ExceptionHandler(ClassCastException.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
       
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body("la cosa ha petado");
    } 
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleClassCastException(Exception e) {
       
        return ResponseEntity
                .status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                .body("Booooom!");
    }   
	
}
