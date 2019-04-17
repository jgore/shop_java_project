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

import javax.accessibility.AccessibleRelation;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderIT {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void create() {
        Order order = new Order();
        OrderLineItem orderLineItem = new OrderLineItem();

        for (int i = 0; i <= 10; i++) {
            Product product = new Product();
            product.setPrice( new BigDecimal(99));
            product.setName("Kurs JAVA 1");
            productRepository.save(product);

            order = new Order();
            orderLineItem  = new OrderLineItem();
            orderLineItem.setAmount(2);
            orderLineItem.setProduct(product);
            orderLineItem.setOrder(order);
            order.setOrderLineItemList(asList(orderLineItem,orderLineItem));

            repository.save(order);
        }
    }
}
