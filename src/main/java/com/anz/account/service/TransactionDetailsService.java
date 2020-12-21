package com.anz.account.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import com.anz.account.model.TransactionDetailsEntity;
import com.anz.account.model.TransactionDetailsVO;

public interface TransactionDetailsService {
	
	public Optional<List<TransactionDetailsEntity>> findByAccountNumber(String accountNumber);
	
	public void convertAccountDetailsToVOObject(List<TransactionDetailsEntity> transactionDetailsList,
			List<TransactionDetailsVO> accountDetailsVOList)throws IllegalAccessException, InvocationTargetException;

}
