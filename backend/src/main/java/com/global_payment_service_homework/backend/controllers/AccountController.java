package com.global_payment_service_homework.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.global_payment_service_homework.backend.models.Account;
import com.global_payment_service_homework.backend.services.AccountService;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> findAllAccounts() {
        return ResponseEntity.ok(accountService.findAllAccounts());
    }

}
