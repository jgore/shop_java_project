package com.example.shop.integration;

import com.example.shop.entity.Order;
import com.example.shop.entity.OrderLineItem;
import com.example.shop.entity.Product;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderIT {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createOrder() {
        Stream.of("java00","java0","java1","java1++").forEach(this::saveOrder);

    }

    private void saveOrder(String prouductName) {
        Order order = new Order();
        Product product = new Product();
        product.setTitle(prouductName);
        product.setPrice(new BigDecimal(999));
        Product savedProd = productRepository.save(product);

        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setAmount(4);

        orderLineItem.setProduct(savedProd);
        orderLineItem.setOrder(order);

        order.setOrderLineItems(Arrays.asList(orderLineItem));

        Order save = orderRepository.save(order);
        save.toString();
    }
}
