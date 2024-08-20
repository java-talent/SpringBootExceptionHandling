package com.javatalent.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	public int statusCode;
	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

}
