package com.projectclick.gestionsegurosvehiculo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleClassCastException(Exception e) {
		ApiError apiError = new ApiError(1, e.getMessage());
       
        return ResponseEntity
                .status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                .body(apiError);
    } 

}
