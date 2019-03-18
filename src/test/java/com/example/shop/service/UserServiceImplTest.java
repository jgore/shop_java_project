package com.example.shop.service;

import com.example.shop.dto.UserDto;
import com.example.shop.entity.User;
import com.example.shop.repository.IRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private static final Long VALID_ID = 1L;

    @Mock
    private IRepository<User> repository;

    @InjectMocks
    private UserServiceImpl service;

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
        UserDto dto = createUser();
        service.save(dto);

        verify(repository, times(1)).save(any());
    }

    @Test
    public void getAll() {
        service.getAll();
        verify(repository, times(1)).getAll();
    }

    @Test
    public void update() {
        UserDto dto = createUser();
        service.update(dto);
        verify(repository, times(1)).update(any());
    }

    @Test
    public void delete() {
        UserDto dto = createUser();
        service.delete(dto);

        verify(repository, times(1)).delete(any());
    }

    @Test
    public void deleteAll() {
        service.deleteAll();

        verify(repository, times(1)).deleteAll();
    }

    private UserDto createUser() {
        return new UserDto();
    }


}
