package com.javatalent.exception;

public class NoSuchCustomerExistsException extends RuntimeException {
	private String message;

	public NoSuchCustomerExistsException() {
	}

	public NoSuchCustomerExistsException(String message) {
		super(message);
		this.message = message;
	}
}
