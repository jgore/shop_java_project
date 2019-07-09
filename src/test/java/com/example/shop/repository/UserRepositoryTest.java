package com.example.shop.repository;

import com.example.shop.TestConfig;
import com.example.shop.entity.Account;
import com.example.shop.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { TestConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class UserRepositoryTest extends AbstractRepositoryTest<User> {


    @Test
    public void update() {
        User user = createEntity();
        repository.save(user);
        User user1 = repository.getAll().get(0);

        user1.setLogin("Test");
        User update = repository.update(user);

        assertThat(user, equalTo(update));
    }

    @Override
    protected User createEntity() {
        User user = new User();
        user.setLogin("test1234"+Math.random());
        user.setEmail("testEmail"+Math.random());
        user.setAccount( new Account());
        return user;
    }
}
