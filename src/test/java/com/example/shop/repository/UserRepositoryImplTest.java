package com.example.shop.repository;

import com.example.shop.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryImplTest extends AbstractRepositoryTest<User> {

    @Autowired
    @Qualifier(value = "userRepositoryImpl")
    private IRepository<User> repository;


    @Test
    public void get() {
        User user = createEntity();
        repository.save(user);
        User user2 = repository.get(user.getId());
        assertThat(user.getId(), equalTo(user2.getId()));
    }

    @Test
    @Ignore
    public void update() {
        User user = createEntity();
        repository.save(user);
        User user1 = repository.getAll().get(0);

        user1.setLogin("Test");
        User update = repository.update(user);

        assertThat(user, equalTo(update));
    }

    @Override
    User createEntity() {
        return new User();
    }
}
