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

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderIT {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createOrder() {
        Order order = new Order();
        Product product = new Product();
        product.setTitle("Korepetycje");
        product.setPrice(new BigDecimal(35));
        Product product1 = new Product();
        product1.setTitle("Support");
        product1.setPrice(new BigDecimal(35));
        Product savedProd = productRepository.save(product);
        Product savedProd1 = productRepository.save(product1);

        Product product2 = new Product();
        product2.setTitle("Znizka");
        product2.setPrice(new BigDecimal(14));

        OrderLineItem orderLineItem = new OrderLineItem();
        OrderLineItem orderLineItem1 = new OrderLineItem();
        orderLineItem.setAmount(4);

        orderLineItem.setProduct(savedProd);
        orderLineItem.setOrder(order);
        orderLineItem1.setAmount(4);

        orderLineItem1.setProduct(savedProd1);
        orderLineItem1.setOrder(order);

        order.setOrderLineItems(Arrays.asList(orderLineItem, orderLineItem1));

        orderRepository.save(order);
    }
}
