package com.anz.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ACCOUNT_DETAILS")
public class AccountDetailsEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ACCOUNT_NUMBER", updatable = false, nullable = false)
	private String accountNumber;
	private String accountName;
	private String accountType;
	private String currency;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/mm/yyyy")
	private Date balanceDate;
	private BigDecimal AvailableBalance;
	@Column(name = "ACCT_USER_ID")
	private String userId;
	private String accountStatus;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="ACCT_NBR",referencedColumnName="ACCOUNT_NUMBER")
    private Set<TransactionDetailsEntity> transactionInformationDetails;
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Set<TransactionDetailsEntity> getTransactionInformationDetails() {
		return transactionInformationDetails;
	}

	public void setTransactionInformationDetails(Set<TransactionDetailsEntity> transactionInformationDetails) {
		this.transactionInformationDetails = transactionInformationDetails;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	

}
