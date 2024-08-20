package com.javatalent.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	private String message;

	public CustomerAlreadyExistsException() {
	}

	public CustomerAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
