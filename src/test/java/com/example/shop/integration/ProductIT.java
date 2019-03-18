package com.example.shop.integration;


import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductIT {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void create() {
        Product product;

        for (int i = 0; i < 20; i++) {
            product = new Product();
            product.setTitle("tit" + Math.random());
            product.setDescription("desc" + Math.random());
            product.setPrice(BigDecimal.ONE);
            productRepository.save(product);
        }
    }
}
