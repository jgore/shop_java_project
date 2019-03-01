package com.example.shop.repository;

import com.example.shop.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractRepository<User> {

    public UserRepository() {
        setClazz(User.class);
    }
}
