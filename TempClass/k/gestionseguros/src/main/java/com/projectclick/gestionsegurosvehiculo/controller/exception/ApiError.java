package com.projectclick.gestionsegurosvehiculo.controller.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/*
 * status: the HTTP status code
	message: the error message associated with exception
	error: List of constructed error messages
 */
public class ApiError{
	
	private Integer code;
    private HttpStatus status;
    private String message;
    private List<String> errors;
 
    
    
	public ApiError() {
		super();
	}

	public ApiError(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
 
    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ApiError [code=" + code + ", status=" + status + ", message=" + message + ", errors=" + errors + "]";
	}
	 
}
