package com.techmatrix.rapidpay.database.repo;

import com.techmatrix.rapidpay.database.entities.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<AccountEntity, Integer> {
    @Query("SELECT accountEntity FROM AccountEntity accountEntity WHERE accountEntity.accountNumber = ?1")
    AccountEntity getAccountEntityByAccountNumber(Long accountNumber);
}
