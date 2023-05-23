package com.techmatrix.rapidpay.service;

import com.techmatrix.rapidpay.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account getAccountById(Integer accountId);
    void createAccount(Account account);
}
