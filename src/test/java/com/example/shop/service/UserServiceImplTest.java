package com.example.shop.service;

import com.example.shop.controller.dto.AccountDto;
import com.example.shop.controller.dto.UserDto;
import com.example.shop.entity.Account;
import com.example.shop.entity.User;
import com.example.shop.mapper.AccountMapper;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.IRepository;
import com.example.shop.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    private static final Long VALID_ID = 1L;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup() {
        when(userMapper.map(any(User.class))).thenReturn(new UserDto());
        when(userMapper.map(any(UserDto.class))).thenReturn(new User());
        when(accountMapper.map(any(Account.class))).thenReturn(new AccountDto());
        when(accountMapper.map(any(AccountDto.class))).thenReturn(new Account());
        when(repository.get(anyLong())).thenReturn( new User());
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void get() {
        userService.get(VALID_ID);

        verify(repository, times(1)).get(anyLong());
    }

    @Test
    public void save() {
        User user = createUser();
        userService.save(user);

        verify(repository, times(1)).save(any());
    }

    @Test
    public void getAll() {
        userService.getAll();
        verify(repository, times(1)).getAll();
    }

    @Test
    public void update() {
        User user = createUser();
        userService.update(user);
        verify(repository, times(1)).update(any());
    }

    @Test
    public void delete() {
        User user = createUser();
        userService.delete(user.getId());

        verify(repository, times(1)).delete(any());
    }

    @Test
    public void deleteAll() {
        userService.deleteAll();

        verify(repository, times(1)).deleteAll();
    }

    private User createUser() {
        return new User();
    }


}
