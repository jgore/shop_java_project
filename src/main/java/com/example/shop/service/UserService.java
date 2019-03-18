package com.example.shop.service;

import com.example.shop.controller.dto.UserDto;
import com.example.shop.entity.Identifable;

public interface UserService<E extends Identifable,DTO> extends IService<E,DTO> {
    UserDto getByLogin(String login);
}
