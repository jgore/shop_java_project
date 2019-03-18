package com.example.shop.dto;

import com.example.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements AbstractMapper<User, UserDto> {

    private AccountMapper accountMapper;

    @Autowired
    public UserMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setLogin(dto.getLogin());
        user.setAccount(accountMapper.dtoToEntity(dto.getAccountDto()));
        return user;
    }

    @Override
    public UserDto entityToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        dto.setId(user.getId());
        dto.setAccountDto(accountMapper.entityToDto(user.getAccount()));
        return dto;
    }
}
