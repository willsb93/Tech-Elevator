package com.techelevator.exceptions;

public class StevesException extends Exception {
	
	private String message;
	private int errorCode;
	private String kidsName;
	
	public StevesException (String message, int errorCode) {
	   super();
	   this.message = message;
	   this.errorCode = errorCode;
    }

}
