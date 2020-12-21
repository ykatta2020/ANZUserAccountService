package com.anz.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Description : TransactionDetailsNotFoundException is used as Customer Exception and used when Transaction Details not available
 * @author ANZ
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionDetailsNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public TransactionDetailsNotFoundException(String message) {
		super(message);
	}

}
