package com.anz.account.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import com.anz.account.model.AccountDetailsEntity;
import com.anz.account.model.AccountDetailsVO;

public interface AccountDetailsService {
	
	public Optional<List<AccountDetailsEntity>> findAccountByUserIdAndStatus(String userId,String accountStatus);
	
	public void convertAccountDetailsToVOObject(List<AccountDetailsEntity> accountDetailsList,
			List<AccountDetailsVO> accountDetailsVOList)throws IllegalAccessException, InvocationTargetException;

}
