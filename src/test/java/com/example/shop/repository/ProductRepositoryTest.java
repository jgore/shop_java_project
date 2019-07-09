package com.example.shop.repository;

import com.example.shop.TestConfig;
import com.example.shop.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { TestConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
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
