package com.michelecossu.appbalance.service.exception;

public class BankAccountNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BankAccountNotFound(String message) {
		super(message);
	}

}
