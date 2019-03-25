package com.example.shop.repository;

import com.example.shop.entity.Product;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest extends AbstractRepositoryTest<Product> {

    @Autowired
    ProductRepository repository;

    @Test
    public void get() {
        Product product = createEntity();
        repository.save(product);

        Product product1 = repository.get(product.getId());

        assertThat(product1.getId(), equalTo(product.getId()));
    }

    @Test
    @Ignore
    //FIXME
    public void update() {
        Product product = createEntity();
        repository.save(product);
        Product product1 = repository.getAll().get(0);

        product1.setName("Test");
        repository.update(product);

        assertThat(product, equalTo(product1));

    }

    @Override
    Product createEntity() {
        return new Product();
    }
}
