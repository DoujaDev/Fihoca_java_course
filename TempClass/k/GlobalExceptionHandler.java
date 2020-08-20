package com.DevSoft.helloworld.backend.services.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.DevSoft.helloworld.backend.services.model.ApiError;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleClassCastException(Exception e) {
		ApiError apiError = new ApiError(1, "Error de prueba");
       
        return ResponseEntity
                .status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                .body(apiError);
    } 

}
