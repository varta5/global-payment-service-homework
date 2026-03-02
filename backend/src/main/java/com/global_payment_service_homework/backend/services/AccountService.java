package com.global_payment_service_homework.backend.services;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

import com.global_payment_service_homework.backend.dtos.PostAccountRequestDto;
import com.global_payment_service_homework.backend.dtos.TransferMoneyDto;
import com.global_payment_service_homework.backend.exceptions.BadRequestException;
import com.global_payment_service_homework.backend.exceptions.NotFoundException;
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

    public Account getAccount(UUID id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
    }

    public Account createAccount(PostAccountRequestDto accountDto) {
        Account account = this.modelMapper.map(accountDto, Account.class);
        return accountRepository.save(account);
    }

    public Account transferMoney(TransferMoneyDto tranferMoneyDto) throws BadRequestException {
        Account sourceAccount = this.getAccount(tranferMoneyDto.getSourceAccountId());
        Account targetAccount = this.getAccount(tranferMoneyDto.getTargetAccountId());
        if (sourceAccount.getId() == targetAccount.getId()) {
            throw new BadRequestException("Source and target accounts are the same");
        }
        if (sourceAccount.getCurrency() != targetAccount.getCurrency()) {
            throw new BadRequestException("Currency of target account does not match that of source account");
        }
        if (sourceAccount.getBalance() < tranferMoneyDto.getAmount()) {
            throw new BadRequestException("The balance of source acount is lower than the requested amount to be transferred");
        }
        sourceAccount.deduct(tranferMoneyDto.getAmount());
        targetAccount.credit(tranferMoneyDto.getAmount());
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
        return sourceAccount;
    }

}
