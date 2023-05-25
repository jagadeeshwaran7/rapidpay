package com.techmatrix.rapidpay.transformer;

import com.techmatrix.rapidpay.database.entities.AccountEntity;
import com.techmatrix.rapidpay.models.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountTransformer {

    AccountEntity transformToAccountEntity(Account account);
    Account transformToAccount(AccountEntity accountEntity);
}

