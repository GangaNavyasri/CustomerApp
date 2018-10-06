package com.capgemini.customerapp.Exceptions;

public class CustomerAlreadyRegisteredException extends RuntimeException {
    public CustomerAlreadyRegisteredException(String message) {
    	super(message);
    }
	
	
}
