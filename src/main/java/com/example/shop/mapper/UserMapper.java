package com.example.shop.mapper;

import com.example.shop.controller.dto.UserDto;
import com.example.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User,UserDto> {

    private AccountMapper accountMapper;

    @Autowired
    public UserMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public UserDto map(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setAccountDto(accountMapper.map(user.getAccount()));
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        return dto;

    }

    public User map(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setAccount(accountMapper.map(dto.getAccountDto()));
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        user.setEmail(dto.getEmail());
        return user;

    }
}
