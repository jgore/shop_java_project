package com.example.shop.controller;

import com.example.shop.ShopApplication;
import com.example.shop.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = ShopApplication.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl service;

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(get("/user/1")
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void saveUser() throws Exception {
        mockMvc.perform(post("/user/").contentType(APPLICATION_JSON)
                .content("{}"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(delete("/user")
                .contentType(APPLICATION_JSON)
                .content("{}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateUser() throws Exception {
        mockMvc.perform(put("/user")
                .contentType(APPLICATION_JSON)
                .content("{}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllUsers() throws Exception {
        mockMvc.perform(get("/user/getAll")
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}


