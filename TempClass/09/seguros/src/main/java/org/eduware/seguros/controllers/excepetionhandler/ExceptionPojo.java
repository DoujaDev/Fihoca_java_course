package org.eduware.seguros.controllers.excepetionhandler;

public class ExceptionPojo {
	
	private String message;
	
	public ExceptionPojo() {
		
	}
	
	public ExceptionPojo( String message) {

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
		return "ExceptionPojo [message=" + message + "]";
	}
	
}
