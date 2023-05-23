package com.techmatrix.rapidpay.database.repo;

import com.techmatrix.rapidpay.database.entities.UpiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpiRepo extends CrudRepository<UpiEntity, Integer> {
}
