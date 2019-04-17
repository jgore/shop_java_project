package com.example.shop.repository;

import com.example.shop.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends AbstractRepository<Order> implements OrderRepository
{
    public OrderRepositoryImpl() {
        setClazz(Order.class);
    }


}
