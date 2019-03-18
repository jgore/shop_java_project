package com.example.shop.repository;

import com.example.shop.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends AbstractRepository<Product> implements ProductRepository {

    public ProductRepositoryImpl() {
        setClazz(Product.class);
    }
}
