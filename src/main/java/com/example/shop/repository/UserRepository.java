package com.example.shop.repository;

import com.example.shop.entity.User;

public interface UserRepository extends IRepository<User> {
     User getByLogin(String login);
}
