package com.anz.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountDetailsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String accountNumber;
	private String accountName;
	private String accountType;
	private String currency;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date balanceDate;
	private BigDecimal AvailableBalance;
	private String accountStatus;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}
	public BigDecimal getAvailableBalance() {
		return AvailableBalance;
	}
	public void setAvailableBalance(BigDecimal availableBalance) {
		AvailableBalance = availableBalance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}
