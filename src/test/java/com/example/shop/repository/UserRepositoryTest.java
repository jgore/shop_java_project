package com.example.shop.repository;

import com.example.shop.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest extends AbstractRepositoryTest<User> {

    @Autowired
    IRepository<User> userRepository;

    @Override
    User createEntity() {
        return new User();
    }

    @Test
    public void get() {
        User user = createEntity();
        userRepository.save(user);
        User user2 = userRepository.get(user.getId());
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
}
