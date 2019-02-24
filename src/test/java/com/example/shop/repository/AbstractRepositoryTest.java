package com.example.shop.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public abstract class AbstractRepositoryTest<Entity> {

    @Autowired
    private IRepository<Entity> repository;


    private Entity abstractEntity;

    abstract Entity createEntity();

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void create() {
        abstractEntity = createEntity();
        repository.save(abstractEntity);
        List<Entity> all = repository.getAll();

        assertThat(all.size(), equalTo(1));
    }

    @Test
    public void getAll() {
        abstractEntity = createEntity();
        repository.save(abstractEntity);
        Entity e = createEntity();
        repository.save(e);

        List<Entity> all = repository.getAll();
        assertThat(all.size(), equalTo(2));
    }

    @Test
    public void deleteAll() {
        abstractEntity = createEntity();
        repository.save(abstractEntity);
        repository.deleteAll();
        List<Entity> all = repository.getAll();

        assertThat(all.size(), equalTo(0));
    }
}
