package com.techmatrix.rapidpay.service;

import com.techmatrix.rapidpay.database.entities.AccountEntity;
import com.techmatrix.rapidpay.database.repo.AccountRepo;
import com.techmatrix.rapidpay.models.Account;
import com.techmatrix.rapidpay.transformer.AccountTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepo accountRepo;
    private final AccountTransformer accountTransformer;
    @Override
    public List<Account> getAllAccount() {
        List<Account> accounts = new ArrayList<>();
        for (AccountEntity accountEntity : accountRepo.findAll()) {
            accounts.add(accountTransformer.transformToAccount(accountEntity));
        }
        return accounts;
    }

    @Override
    public Account getAccountById(Integer accountId) {
        return accountTransformer.transformToAccount(accountRepo.findById(accountId).orElse(null));
    }

    @Override
    public void createAccount(Account account) {
        accountRepo.save(accountTransformer.transformToAccountEntity(account));
    }
}
