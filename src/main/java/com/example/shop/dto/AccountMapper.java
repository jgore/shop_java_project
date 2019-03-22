package com.example.shop.dto;

import com.example.shop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements AbstractMapper<Account, AccountDto> {


    @Override
    public Account dtoToEntity(AccountDto dto) {
        if (dto ==null) {
            return null;
        }
        Account account = new Account();
        account.setId(dto.getId());
        return account;
    }

    @Override
    public AccountDto entityToDto(Account account) {
        if (account == null) {
            return null;
        }
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        return dto;
    }
}
