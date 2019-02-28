package com.example.shop.service;

import com.example.shop.entity.User;
import com.example.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    public UserService(@Qualifier("userRepository") IRepository<User> repository) {
        super(repository);
    }
}
