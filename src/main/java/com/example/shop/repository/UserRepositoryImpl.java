package com.example.shop.repository;

import com.example.shop.entity.Account;
import com.example.shop.entity.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    public UserRepositoryImpl() {
        setClazz(User.class);
    }

    @Override
    @Transactional
    public User save(User user) {
        Account account = new Account();
        account.setUser(user);
        user.setAccount(account);
        return super.save(user);
    }
}
