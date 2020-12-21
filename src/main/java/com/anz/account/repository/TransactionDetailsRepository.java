package com.anz.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.account.model.TransactionDetailsEntity;
/**
 * Description : TransactionDetailsRepository is used for Transaction Details functionalities based on TRANSACTION_DETAILS table
 * @author ANZ
 *
 */
@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetailsEntity,Long> {
	/**
	 * Description : findByAccountNumber(..) method is used to fetch transaction details based on account number
	 * @Param String accountNumber
	 * @return  Optional<List<TransactionDetailsEntity>>
	 */
	Optional<List<TransactionDetailsEntity>> findByAccountNumber(String accountNumber);

}
