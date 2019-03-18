package com.example.shop.repository;

import com.example.shop.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTest extends AbstractRepositoryTest<Product> {

    @Override
    Product createEntity() {
        return new Product();
    }

    @Test
    @Override
    public void update() {
        Product product = createEntity();
        repository.save(product);
        Product productPersisted = repository.getAll().get(0);

        productPersisted.setTitle("Test");
        Product updated = repository.update(productPersisted);

        assertThat(updated, equalTo(productPersisted));
    }
}
