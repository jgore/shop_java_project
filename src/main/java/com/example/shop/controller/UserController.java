package com.example.shop.controller;

import com.example.shop.dto.UserDto;
import com.example.shop.dto.UserMapper;
import com.example.shop.entity.User;
import com.example.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/user")
public class UserController implements IController<UserDto> {

    private UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.service = userServiceImpl;
    }

    @Override
    @RequestMapping(value = "/{id}",method = GET)
    public UserDto get(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/getAll", method = GET)
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    @RequestMapping(method = POST)
    public UserDto save(@RequestBody UserDto dto) {
        return null;
    }

    @Override
    @RequestMapping(method = PUT)
    public UserDto update(@RequestBody UserDto user) {
        return null;
    }

    @Override
    @RequestMapping(method = DELETE)
    public UserDto delete(@RequestBody UserDto user) {
        return null;
    }
}
