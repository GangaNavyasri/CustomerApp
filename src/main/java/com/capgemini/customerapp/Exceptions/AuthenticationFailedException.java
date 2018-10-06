package com.capgemini.customerapp.Exceptions;

public class AuthenticationFailedException extends RuntimeException {
 public AuthenticationFailedException(String message) {
	 super(message);
 }
}
