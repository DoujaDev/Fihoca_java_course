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
                .body(new ExceptionPojo(e.getMessage()));
    }  
	
	@ExceptionHandler(org.apache.tomcat.util.json.ParseException.class)
    public ResponseEntity<ExceptionPojo> handleFechaException(org.apache.tomcat.util.json.ParseException e) {
       
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ExceptionPojo(e.getMessage()));
    }   
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionPojo> handleClassCastException(Exception e) {
       
        return ResponseEntity
                .status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                .body(new ExceptionPojo("Pué parese que algo no funsiona!"));
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
