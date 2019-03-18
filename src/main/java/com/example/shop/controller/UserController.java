package com.example.shop.controller;

import com.example.shop.controller.dto.UserDto;
import com.example.shop.entity.User;
import com.example.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/user")
public class UserController implements IController<User,UserDto> {

    private UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.service = userServiceImpl;
    }

    @Override
    @RequestMapping(value = "/{id}",method = GET)
    public UserDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @Override
    @RequestMapping( method = GET)
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @Override
    @RequestMapping(method = POST)
    public UserDto save(@RequestBody User user) {
            return service.save(user);
    }

    @Override
    @RequestMapping(method = PUT)
    public UserDto update(@RequestBody User user) {
        return service.update(user);
    }

    @Override
    @RequestMapping(value = "{id}", method = DELETE)
    public UserDto delete(@PathVariable("id") Long id ) {
        return service.delete(id);
    }
}
