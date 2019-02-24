package com.example.shop.repository;

import com.example.shop.entity.Account;
import com.example.shop.entity.User;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest extends AbstractRepositoryTest<Account> {

    @Autowired
    @Qualifier("accountRepository")
    IRepository<Account> repository;


    @Override
    Account createEntity() {
        return new Account();
    }

    @Test
    public void get() {
        Account account = createEntity();
        repository.save(account);
        Account account1 = repository.get(account.getId());

        assertThat(account1.getId(), equalTo(account.getId()));
    }
}
