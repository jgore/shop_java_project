package com.example.shop.service;

import com.example.shop.dto.AbstractMapper;
import com.example.shop.dto.AccountDto;
import com.example.shop.dto.AccountMapper;
import com.example.shop.entity.Account;
import com.example.shop.repository.AccountRepository;
import com.example.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends AbstractService<Account, AccountDto> implements AccountService {
    private AccountRepository repository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository repository, AccountMapper accountMapper) {
        super(repository, accountMapper);
    }
}
