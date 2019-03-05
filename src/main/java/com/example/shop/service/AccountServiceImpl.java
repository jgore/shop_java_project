package com.example.shop.service;

import com.example.shop.entity.Account;
import com.example.shop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account get(Long id) {
        return accountRepository.get(id);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.getAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.update(account);
    }

    @Override
    public Account delete(Account account) {
        return accountRepository.delete(account);
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
