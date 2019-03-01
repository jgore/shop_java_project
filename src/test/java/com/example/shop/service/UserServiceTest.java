package com.example.shop.service;

import com.example.shop.entity.User;
import com.example.shop.repository.IRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    private static final Long VALID_ID = 1L;

    @Mock
    private IRepository<User> repository;

    @InjectMocks
    private UserService service;

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void get() {
        service.get(VALID_ID);

        verify(repository, times(1)).get(anyLong());
    }

    @Test
    public void save() {
        User user = createUser();
        service.save(user);

        verify(repository, times(1)).save(any());
    }

    @Test
    public void getAll() {
        service.getAll();
        verify(repository, times(1)).getAll();
    }

    @Test
    public void update() {
        User user = createUser();
        service.update(user);
        verify(repository, times(1)).update(any());
    }

    @Test
    public void delete() {
        User user = createUser();
        service.delete(user);

        verify(repository, times(1)).delete(any());
    }

    @Test
    public void deleteAll() {
        service.deleteAll();

        verify(repository, times(1)).deleteAll();
    }

    private User createUser() {
        return new User();
    }


}
