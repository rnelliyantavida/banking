package com.springBootProject.accountTransaction.services;

import com.springBootProject.accountTransaction.beans.Account;
import com.springBootProject.accountTransaction.beans.Transaction;
import com.springBootProject.accountTransaction.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Transaction> transactionDetails(long accNo) {
        List<Account> transactions = new ArrayList<>();
        List<Transaction> details = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();
        for(Account account: accounts){
            if(account.getAccNo() == accNo){
                transactions.add(account);
                details.add(new Transaction(account.getLastTransaction(),account.getAmount(),account.getTransactionDate()));
            }
        }
        return details;
    }

    public Account addTransaction(Account account) {
        account.setAccId(accountRepository.findAll().size()+1);
        account.setTransactionDate(LocalDate.now());
        return accountRepository.save(account);
    }
}
