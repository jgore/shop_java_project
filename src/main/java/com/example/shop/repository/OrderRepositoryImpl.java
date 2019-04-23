package com.example.shop.repository;

import com.example.shop.entity.Order;
import com.example.shop.entity.OrderLineItem;
import com.example.shop.entity.OrderStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Arrays;

@Repository
public class OrderRepositoryImpl extends AbstractRepository<Order> implements OrderRepository
{
    public OrderRepositoryImpl() {
        setClazz(Order.class);
    }

    @Override
    @Transactional
    public Order delete(Order order) {
        order.setStatus(OrderStatus.DELETED);
        return super.update(order);
    }
}
