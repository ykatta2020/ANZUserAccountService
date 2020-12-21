package com.anz.account.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import com.anz.account.model.AccountDetailsEntity;
import com.anz.account.model.AccountDetailsVO;
import com.anz.account.repository.AccountDetailsRepository;
/**
 * Description : AccountDetailsServiceImpl is used for  User Account Details functionalities
 * @author ANZ
 *
 */
@Service
public class AccountDetailsServiceImpl implements AccountDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(AccountDetailsServiceImpl.class);
	
	@Autowired
	private AccountDetailsRepository  accountDetailsRepository;
	/**
	 * Description : findAccountByUserIdAndStatus(..) method is used to fetch Account Details based on userid and account Status as Active
	 * @Param String userId
	 * @return  Optional<List<AccountDetailsEntity>>
	 */
	@Override
	@Cacheable(value="accounts", key="#userId")
	@Transactional(readOnly = true) 
	public Optional<List<AccountDetailsEntity>> findAccountByUserIdAndStatus(String userId, String accountStatus) {
		// TODO Auto-generated method stub
		logger.debug("logged in User Id{}",userId);
		return accountDetailsRepository.findAccountByUserIdAndStatus(userId, accountStatus);
	}
	/**
	 * Description : convertAccountDetailsToVOObject(..) method is used to convert AccountDetailsEntity to AccountDetailsVO object
	 * @Params List<AccountDetailsEntity> accountDetailsList,
			List<AccountDetailsVO> accountDetailsVOList
	 * @return  void
	 */
	@Override
	public void convertAccountDetailsToVOObject(List<AccountDetailsEntity> accountDetailsList,
			List<AccountDetailsVO> accountDetailsVOList) throws IllegalAccessException, InvocationTargetException {
		logger.info("convertAccountDetailsToVOObject(..) method execution Start");
		AccountDetailsVO accountDetailsVO=null;
		for(AccountDetailsEntity accountDetailsEntity:accountDetailsList) {
			accountDetailsVO=new AccountDetailsVO();
			BeanUtils.copyProperties(accountDetailsVO, accountDetailsEntity);
			accountDetailsVOList.add(accountDetailsVO);
		}
		logger.info("convertAccountDetailsToVOObject(..) method execution End");
	}

}
