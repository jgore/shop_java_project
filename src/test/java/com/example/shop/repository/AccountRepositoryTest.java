package com.example.shop.repository;

import com.example.shop.entity.Account;
import com.example.shop.entity.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountRepositoryTest extends AbstractRepositoryTest<Account> {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @After
    public void tearDown() {
        accountRepository.deleteAll();
    }

    @Override
    @Test
    public void create() {
        User user = createUser();
        Account account = createEntity();
        account.setUser(user);

        accountRepository.save(account);
        List<Account> all = accountRepository.getAll();
        assertThat(all.size(), equalTo(1));
    }

    @Override
    @Test
    public void getAll() {
        User user1 = createUser();
        User user2 = createUser();

        Account account = createEntity();
        Account account2 = createEntity();
        account.setUser(user1);
        account2.setUser(user2);

        accountRepository.save(account);
        accountRepository.save(account2);

        List<Account> all = accountRepository.getAll();
        assertThat(all.size(), equalTo(2));
    }

    @Override
    @Test
    public void delete() {
        User user = createUser();
        Account account = createEntity();

        account.setUser(user);
        accountRepository.save(account);
        Account account2 = accountRepository.getAll().get(0);

        accountRepository.delete(account2);
        List<Account> all = accountRepository.getAll();
        assertThat(all.size(), equalTo(0));
    }

    @Override
    @Test
    public void deleteAll() {
        User user = createUser();
        Account account = createEntity();

        account.setUser(user);
        accountRepository.save(account);
        accountRepository.deleteAll();

        assertThat(accountRepository.getAll().size(), equalTo(0));
    }

    @Test
    public void get() {
        User user = createUser();
        Account account = createEntity();
        account.setUser(user);

        accountRepository.save(account);

        Account account1 = accountRepository.get(account.getId());
        assertThat(account.getId(), equalTo(account1.getId()));
    }

    @Test
    public void update() {
        User user = createUser();
        Account account = createEntity();

        account.setUser(user);

        accountRepository.save(account);
        Account account1 = accountRepository.getAll().get(0);
        User user1 = createUser();
        account1.setUser(user1);

        accountRepository.update(account);

        assertThat(account, equalTo(account1));


    }

    @Override
    Account createEntity() {
        return new Account();
    }

    private User createUser() {
        return new User();
    }
}
