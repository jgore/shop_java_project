package com.example.shop.service;

import com.example.shop.dto.UserDto;
import com.example.shop.dto.UserMapper;
import com.example.shop.entity.User;
import com.example.shop.repository.IRepository;
import com.example.shop.repository.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private static final Long VALID_ID = 1L;

    @Mock
    private UserRepository repository;

    @Mock
    UserMapper userMapper;

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
