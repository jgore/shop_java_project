package com.example.shop.repository;

import com.example.shop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository extends AbstractRepository<Account> {

    public AccountRepository() {
        setClazz(Account.class);
    }
}
