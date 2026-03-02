package com.global_payment_service_homework.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.global_payment_service_homework.backend.dtos.PostAccountRequestDto;
import com.global_payment_service_homework.backend.models.Account;
import com.global_payment_service_homework.backend.services.AccountService;

@RestController
@RequestMapping(value = "/api")
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

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody(required = false) PostAccountRequestDto accountDto) {
        return ResponseEntity.ok(accountService.createAccount(accountDto));
    }

}
