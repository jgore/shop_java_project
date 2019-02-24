package com.example.shop.repository;

import com.example.shop.entity.User;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.cs.US_ASCII;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest extends AbstractRepositoryTest<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    User createEntity() {
        return new User();
    }

    @Test
    public void get() {
        User user = createEntity();
        userRepository.save(user);
        User user2 = userRepository.getAll().get(0);
        assertThat(user.getId(), equalTo(user2.getId()));
    }

    @Test
    public void update() {
        User user = createEntity();
        userRepository.save(user);
        User user1 = userRepository.getAll().get(0);

        user1.setLogin("Test");
        User update = userRepository.update(user);

        assertThat(user, equalTo(update));
    }

    @Test
    public void delete() {
        User user = createEntity();
        userRepository.save(user);
        User user1 = userRepository.getAll().get(0);
        userRepository.delete(user1);

        List<User> all = userRepository.getAll();
        assertThat(all.size(), equalTo(0));
    }

    @Test
    public void deleteById() {
        User user = createEntity();
        userRepository.save(user);
        userRepository.deleteById(user.getId());

        List<User> all = userRepository.getAll();
        assertThat(all.size(), equalTo(0));
    }
}
