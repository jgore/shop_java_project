package com.example.shop.repository;

import com.example.shop.entity.Order;
import com.example.shop.entity.OrderLineItem;
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
    public Order save(Order order) {
        OrderLineItem orderLineItem = new OrderLineItem();
        order.setOrderLineItemList(Arrays.asList(orderLineItem));
        orderLineItem.setOrder(order);
       return super.save(order);
    }
}
