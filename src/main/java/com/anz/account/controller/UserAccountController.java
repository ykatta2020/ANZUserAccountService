package com.anz.account.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.exception.AccountDetailsNotFoundException;
import com.anz.account.exception.TransactionDetailsNotFoundException;
import com.anz.account.model.AccountDetailsEntity;
import com.anz.account.model.AccountDetailsVO;
import com.anz.account.model.TransactionDetailsEntity;
import com.anz.account.model.TransactionDetailsVO;
import com.anz.account.service.AccountDetailsService;
import com.anz.account.service.TransactionDetailsService;
import com.anz.account.util.AccountServiceMsg;

/**
 * Description : UserAccountController is used for  User Account Details and Account Transaction details functionalities
 * @author ANZ
 *
 */
@RestController
@RequestMapping(path = "/ANZ")
public class UserAccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAccountController.class);
	
	
	@Autowired
	private AccountDetailsService accountDetailsService;
	@Autowired
	private TransactionDetailsService transactionDetailsService;
	/**
	 * Description : getUserAccountDetails(..) method is used to fetch Account Details based on logged in User Id
	 * @Param String userId
	 * @return  ResponseEntity<List<AccountDetailsVO>>
	 */
	@GetMapping(path = "/accounts/{userId}")
	public ResponseEntity<List<AccountDetailsVO>> getUserAccountDetails(@PathVariable String userId) throws Exception{
			logger.info("getUserAccountDetails method execution Start");
			logger.debug("logged in User Id{}",userId); 
			List<AccountDetailsVO> accountDetailsVOList = fetchUserAccountDetails(userId);
			logger.info("getUserAccountDetails method execution End");
			return new ResponseEntity<>(accountDetailsVOList, HttpStatus.OK);	
	}

	public List<AccountDetailsVO> fetchUserAccountDetails(String userId)
			throws IllegalAccessException, InvocationTargetException {
		Optional<List<AccountDetailsEntity>> accountDetails=accountDetailsService.findAccountByUserIdAndStatus(userId, AccountServiceMsg.ACCOUNT_STATUS.getMessage());
		accountDetails.orElseThrow(()-> new AccountDetailsNotFoundException(AccountServiceMsg.ACCOUNT_NOT_FOUND_EXCEP_MESSAGE.getMessage()+userId));
		List<AccountDetailsEntity> accountDetailsList=accountDetails.get();
		List<AccountDetailsVO> accountDetailsVOList=new ArrayList<>();
		accountDetailsService.convertAccountDetailsToVOObject(accountDetailsList, accountDetailsVOList);
		return accountDetailsVOList;
	}
	/**
	 * Description : backToAccountDetails(..) method is used to fetch Account Details based on logged in User Id Accounts Cache
	 * @Param String userId
	 * @return  ResponseEntity<List<AccountDetailsVO>>
	 */
	@GetMapping(path = "/backToAccounts/{userId}")
	public ResponseEntity<List<AccountDetailsVO>> backToAccountDetails(@PathVariable String userId) throws Exception{
			logger.info("backToAccountDetails(..) method execution Start");
			List<AccountDetailsVO> accountDetailsVOList = fetchUserAccountDetails(userId);
			logger.info("backToAccountDetails(..) method execution End");
			return new ResponseEntity<>(accountDetailsVOList, HttpStatus.OK);	
	}
	/**
	 * Description : getAccountTransactionDetails(..) method is used to fetch Account Details based on logged in User Id Accounts Cache
	 * @Param String accountNumber
	 * @return  ResponseEntity<List<TransactionDetailsVO>>
	 */
	
	@GetMapping(path = "/transactions/{accountNumber}")
	public ResponseEntity<List<TransactionDetailsVO>> getAccountTransactionDetails(@PathVariable String accountNumber) throws Exception{
		logger.info("getAccountTransactionDetails(..) method execution Start");
		Optional<List<TransactionDetailsEntity>> transactionDetails=transactionDetailsService.findByAccountNumber(accountNumber);
		transactionDetails.orElseThrow(()-> new TransactionDetailsNotFoundException(AccountServiceMsg.TRANSACTION_NOT_FOUND_EXCEP_MESSAGE.getMessage()+accountNumber));
		List<TransactionDetailsEntity> transactionDetailsList=transactionDetails.get();
		List<TransactionDetailsVO> accountDetailsVOList=new ArrayList<>();
		transactionDetailsService.convertAccountDetailsToVOObject(transactionDetailsList, accountDetailsVOList);
		logger.info("getAccountTransactionDetails(..) method execution End");
		return new ResponseEntity<>(accountDetailsVOList, HttpStatus.OK);	
	}	

}
