package com.example.shop.service;

import com.example.shop.controller.dto.UserDto;
import com.example.shop.entity.User;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.IRepository;
import com.example.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto> implements UserService<User, UserDto> {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserDto getByLogin(String login) {
        return userMapper.map(userRepository.getByLogin(login));
    }
}
