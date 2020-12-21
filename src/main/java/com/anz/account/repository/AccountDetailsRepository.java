package com.anz.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anz.account.model.AccountDetailsEntity;
/**
 * Description : AccountDetailsRepository is used for  User Account Details functionalities based on ACCOUNT_DETAILS table
 * @author ANZ
 *
 */
@Repository
public interface  AccountDetailsRepository  extends JpaRepository<AccountDetailsEntity,String>{
	/**
	 * Description : findAccountByUserIdAndStatus(..) method is used to fetch Account Details based on user id and account Status as Active
	 * @Param String userId
	 * @return  Optional<List<AccountDetailsEntity>>
	 */
	@Query("SELECT A FROM AccountDetailsEntity A WHERE A.userId = :userId AND A.accountStatus = :accountStatus")
	Optional<List<AccountDetailsEntity>> findAccountByUserIdAndStatus(@Param("userId") String userId,@Param("accountStatus") String accountStatus);

}
