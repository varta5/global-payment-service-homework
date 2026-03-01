package com.global_payment_service_homework.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global_payment_service_homework.backend.models.Account;
import com.global_payment_service_homework.backend.repositories.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

}
