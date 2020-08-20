package com.joancorp.paisgest.controllers.exception;

public class APIerror {

	private String message;

	public APIerror() {
		
	}
	
	public APIerror(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "APIerror [message=" + message + "]";
	}

}
