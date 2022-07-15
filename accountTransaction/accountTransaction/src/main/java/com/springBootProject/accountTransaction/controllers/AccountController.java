package com.springBootProject.accountTransaction.controllers;

import com.springBootProject.accountTransaction.beans.Account;
import com.springBootProject.accountTransaction.beans.Transaction;
import com.springBootProject.accountTransaction.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("transactionDetails/{accNo}")
    public List<Transaction> transactionDetails(@PathVariable long accNo){
        return accountService.transactionDetails(accNo);
    }

    @PostMapping("addTransaction")
    public Account addTransaction(@RequestBody Account account){
        return  accountService.addTransaction(account);
    }

}
