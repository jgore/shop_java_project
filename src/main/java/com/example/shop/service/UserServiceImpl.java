package com.example.shop.service;

import com.example.shop.dto.UserDto;
import com.example.shop.dto.UserMapper;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto> implements UserService {

    private UserRepository repository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper userMapper) {
        super(repository, userMapper);
    }
}
