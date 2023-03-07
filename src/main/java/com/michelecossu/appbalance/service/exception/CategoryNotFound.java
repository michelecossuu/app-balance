package com.michelecossu.appbalance.service.exception;

public class CategoryNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CategoryNotFound(String message) {
		super(message);
	}

}
