package com.anz.account.util;

public enum AccountServiceMsg {
	
	ACCOUNT_NOT_FOUND_EXCEP_MESSAGE("Account Details not available for user::"),
	TRANSACTION_NOT_FOUND_EXCEP_MESSAGE("Transaction Details not available for Account::"),
	ACCOUNT_STATUS("ACTIVE");
	private String message;
	public String getMessage() {
		return message;
	}
	private AccountServiceMsg(String message) {
		this.message=message;	
	}

}
