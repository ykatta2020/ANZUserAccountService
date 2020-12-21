package com.anz.account.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anz.account.model.ResponseMessage;
/**
 * Description : CustomizedResponseEntityExceptionHandler is used as Common Exception  Handling
 * @author ANZ
 *
 */
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	/**
	 * Description : handleAllExceptions(..) method is used for handling all Exceptions
	 * @Param Exception ex, WebRequest request
	 * @return  ResponseEntity<ResponseMessage>
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseMessage> handleAllExceptions(Exception ex, WebRequest request) {
		logger.info("handleAllExceptions(..) method execution");
		ResponseMessage responseMessage = new ResponseMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responseMessage);

	}
	/**
	 * Description : handleAccountDetailsNotFoundException(..) method is used for handling AccountDetailsNotFoundException 
	 * @Param AccountDetailsNotFoundException ex, WebRequest request
	 * @return  ResponseEntity<ResponseMessage>
	 */
	@ExceptionHandler(AccountDetailsNotFoundException.class)
	public final ResponseEntity<ResponseMessage> handleAccountDetailsNotFoundException(
			AccountDetailsNotFoundException ex, WebRequest request) {
		logger.info("handleAccountDetailsNotFoundException(..) method execution");
		ResponseMessage responseMessage = new ResponseMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	}
	/**
	 * Description : handleTransactionDetailsNotFoundException(..) method is used for handling TransactionDetailsNotFoundException 
	 * @Param TransactionDetailsNotFoundException ex, WebRequest request
	 * @return  ResponseEntity<ResponseMessage>
	 */
	@ExceptionHandler(TransactionDetailsNotFoundException.class)
	public final ResponseEntity<ResponseMessage> handleTransactionDetailsNotFoundException(
			TransactionDetailsNotFoundException ex, WebRequest request) {
		logger.info("handleTransactionDetailsNotFoundException(..) method execution");
		ResponseMessage responseMessage = new ResponseMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	}

	
}
