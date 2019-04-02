package com.example.shop.integration;

import com.example.shop.entity.Order;
import com.example.shop.entity.OrderLineItem;
import com.example.shop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderIT {

    @Autowired
    OrderRepository repository;

    @Test
    public void create() {
        Order order = new Order();
        OrderLineItem orderLineItem = new OrderLineItem();

        for (int i = 0; i <= 10; i++) {
            order = new Order();
            orderLineItem  = new OrderLineItem();
            order.setOrderLineItemList(asList(orderLineItem));

            repository.save(order);
        }
    }
}
