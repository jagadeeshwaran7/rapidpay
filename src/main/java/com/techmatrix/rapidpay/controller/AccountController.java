package com.techmatrix.rapidpay.controller;

import com.techmatrix.rapidpay.models.Account;
import com.techmatrix.rapidpay.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccount();
    }
    @GetMapping("/{id}/")
    public  Account getAccountById(@PathParam("id") Integer accountId) {
        return accountService.getAccountById(accountId);
    }
    @PostMapping
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }
}
