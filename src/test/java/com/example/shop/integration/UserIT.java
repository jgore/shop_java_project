package com.example.shop.integration;

import com.example.shop.entity.User;
import com.example.shop.repository.UserRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserIT {

    @Autowired
    private UserRepositoryImpl repository;

    @Test
    public void create() {
        User user = new User();

        //FIXME
        for (int i = 0; i <=100; i++) {
            user = new User();
            user.setEmail("Test@test");
            user.setLogin("Test");
            user.setPassword("Secret");
            repository.save(user);
        }
    }

}
