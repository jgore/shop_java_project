package com.example.shop.repository;

import com.example.shop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl extends AbstractRepository<Account> implements AccountRepository {

    public AccountRepositoryImpl() {
        setClazz(Account.class);
    }
}