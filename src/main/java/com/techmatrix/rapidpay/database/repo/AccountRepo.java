package com.techmatrix.rapidpay.database.repo;

import com.techmatrix.rapidpay.database.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<AccountEntity, Integer> {
}
