package com.example.shop.repository;

import com.example.shop.entity.Identifable;
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
public abstract class AbstractRepositoryTest<E extends Identifable> {

    @Autowired
    IRepository<E> repository;

    private E abstractEntiti;

    abstract E createEntity();

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void create() {
        abstractEntiti = createEntity();
        repository.save(abstractEntiti);
        List<E> all = repository.getAll();

        assertThat(all.size(), equalTo(1));
    }

    @Test
    public void getAll() {
        abstractEntiti = createEntity();
        repository.save(abstractEntiti);
        E e = createEntity();
        repository.save(e);

        List<E> all = repository.getAll();
        assertThat(all.size(), equalTo(2));
    }

    @Test
    public void deleteAll() {
        abstractEntiti = createEntity();
        repository.save(abstractEntiti);
        repository.deleteAll();
        List<E> all = repository.getAll();

        assertThat(all.size(), equalTo(0));
    }

    @Test
    public void delete() {
        abstractEntiti = createEntity();
        repository.save(abstractEntiti);
        E entity = repository.getAll().get(0);
        repository.delete(entity);

        List<E> all = repository.getAll();
        assertThat(all.size(), equalTo(0));
    }
}
