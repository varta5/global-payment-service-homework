package com.global_payment_service_homework.backend.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global_payment_service_homework.backend.dtos.PostAccountRequestDto;
import com.global_payment_service_homework.backend.models.Account;
import com.global_payment_service_homework.backend.repositories.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(PostAccountRequestDto accountDto) {
        Account account = this.modelMapper.map(accountDto, Account.class);
        return accountRepository.save(account);
    }

}
