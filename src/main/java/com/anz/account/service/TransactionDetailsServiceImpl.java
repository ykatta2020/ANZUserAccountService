package com.anz.account.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anz.account.model.TransactionDetailsEntity;
import com.anz.account.model.TransactionDetailsVO;
import com.anz.account.repository.TransactionDetailsRepository;
/**
 * Description : TransactionDetailsServiceImpl is used for  User Transaction Details functionalities
 * @author ANZ
 *
 */
@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionDetailsServiceImpl.class);
	
	@Autowired
	private TransactionDetailsRepository  transactionDetailsRepository;
	/**
	 * Description : findByAccountNumber(..) method is used to fetch transaction details based on account number
	 * @Param String accountNumber
	 * @return  Optional<List<TransactionDetailsEntity>>
	 */
	@Override
	@Transactional(readOnly = true) 
	public Optional<List<TransactionDetailsEntity>> findByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		logger.debug("Account Number{}",accountNumber);
		return transactionDetailsRepository.findByAccountNumber(accountNumber);
	}
	/**
	 * Description : convertAccountDetailsToVOObject(..) method is used to convert TransactionDetailsEntity to TransactionDetailsVO object
	 * @Params List<TransactionDetailsEntity> transactionDetailsList,
			List<TransactionDetailsVO> accountDetailsVOList
	 * @return  void
	 */
	@Override
	public void convertAccountDetailsToVOObject(List<TransactionDetailsEntity> transactionDetailsList,
			List<TransactionDetailsVO> accountDetailsVOList) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		logger.info("convertAccountDetailsToVOObject(..) method execution Start");
		TransactionDetailsVO transactionDetailsVO=null;
		for(TransactionDetailsEntity transactionDetailsEntity:transactionDetailsList) {
			transactionDetailsVO=new TransactionDetailsVO();
			BeanUtils.copyProperties(transactionDetailsVO, transactionDetailsEntity);
			accountDetailsVOList.add(transactionDetailsVO);
		}
		logger.info("convertAccountDetailsToVOObject(..) method execution End");
	}

}
