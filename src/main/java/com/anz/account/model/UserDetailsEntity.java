package com.anz.account.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS") 
public class UserDetailsEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private String userId;
	private String FirstName;
	private String LastName;
	private String userStatus;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER) 
	@JoinColumn(name="ACCT_USER_ID",referencedColumnName="USER_ID") private
	Set<AccountDetailsEntity> accountDetails;
	 
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Set<AccountDetailsEntity> getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(Set<AccountDetailsEntity> accountDetails) {
		this.accountDetails = accountDetails;
	}
	

}
