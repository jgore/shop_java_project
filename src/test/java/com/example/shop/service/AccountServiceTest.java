package com.example.shop.service;

import com.example.shop.entity.Account;
import com.example.shop.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceTest {
    private static final Long VALID_ID = 1L;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void get() {
        accountService.get(VALID_ID);

        verify(accountRepository, times(1)).get(anyLong());
    }

    @Test
    public void save() {
        Account account = createAccount();
        accountService.save(account);

        verify(accountRepository, times(1)).save(any());
    }

    @Test
    public void update() {
        Account account= createAccount();
        accountService.update(account);

        verify(accountRepository, times(1)).update(any());
    }

    @Test
    public void delete() {
        Account account = createAccount();
        accountService.delete(account);

        verify(accountRepository, times(1)).delete(any());
    }

    @Test
    public void deleteAll() {
        accountService.deleteAll();

        verify(accountRepository, times(1)).deleteAll();
    }

    private Account createAccount() {
        return new Account();
    }
}
