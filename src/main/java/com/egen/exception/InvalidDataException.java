package com.egen.exception;

/**
 * Custom Exception Class for Handeling Exception
 * @author Surbhi Tandon
 *
 *
 */
public class InvalidDataException extends Exception{

	private static final long serialVersionUID = -65799152857756226L;
	
	public InvalidDataException() {
		
	}

	public InvalidDataException(String errorMessage) {
		super(errorMessage);
	}
}
