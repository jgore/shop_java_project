package com.example.shop.mapper;

import com.example.shop.controller.dto.AccountDto;
import com.example.shop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements Mapper<Account, AccountDto>{


    public Account map(AccountDto dto) {
        Account account = new Account();
        account.setId(dto.getId());
        return account;
    }

    public AccountDto map(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        return accountDto;
    }
}
