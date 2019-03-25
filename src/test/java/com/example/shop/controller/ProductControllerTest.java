package com.example.shop.controller;

import com.example.shop.ShopApplication;
import com.example.shop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = ShopApplication.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ProductService productService;


    @Test
    public void getProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/product/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/product/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/product/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllProducts() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product/getAll")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
