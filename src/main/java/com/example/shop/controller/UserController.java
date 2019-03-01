package com.example.shop.controller;

import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/user")
public class UserController implements IController<User> {

    private UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @Override
    @RequestMapping(value = "/{id}",method = GET)
    public User get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @Override
    @RequestMapping(value = "/getAll", method = GET)
    public List<User> getAll() {
        return service.getAll();
    }

    @Override
    @RequestMapping(method = POST)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @Override
    @RequestMapping(method = PUT)
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @Override
    @RequestMapping(method = DELETE)
    public User delete(@RequestBody User user) {
        return service.delete(user);
    }
}
