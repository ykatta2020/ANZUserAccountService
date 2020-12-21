package com.anz.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Description : AccountDetailsNotFoundException is used as Customer Exception and used when Account Details not available
 * @author ANZ
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountDetailsNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AccountDetailsNotFoundException(String message) {
		super(message);
	}
}
