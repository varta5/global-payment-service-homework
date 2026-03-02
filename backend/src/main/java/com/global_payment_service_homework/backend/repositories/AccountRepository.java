package com.global_payment_service_homework.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import com.global_payment_service_homework.backend.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    public List<Account> findAll();

    public Account save(Account account);

}
