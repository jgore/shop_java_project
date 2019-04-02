package com.example.shop.repository;

import com.example.shop.entity.Order;
import com.example.shop.entity.OrderLineItem;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest extends AbstractRepositoryTest<Order> {

    @Autowired
    OrderRepository repository;

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Override
    @Test
    public void create() {
        Order order = createEntity();
        OrderLineItem orderLineItem = new OrderLineItem();
        order.setOrderLineItemList(asList(orderLineItem));

        repository.save(order);
        List<Order> all = repository.getAll();
        assertThat(all.size(), equalTo(1));
    }

    @Test
    public void get() {
        Order order = createEntity();
        OrderLineItem orderLineItem = new OrderLineItem();

        order.setOrderLineItemList(asList(orderLineItem));

        repository.save(order);
        Order order1 = repository.getAll().get(0);
        Order order2 = repository.get(order.getId());

        assertThat(order1.getId(), equalTo(order2.getId()));
    }

    @Test
    @Ignore
    public void update() {
        Order order = new Order();
        OrderLineItem orderLineItem = new OrderLineItem();

        order.setOrderLineItemList(asList(orderLineItem));

        repository.save(order);

        Order order1 = repository.getAll().get(0);
        order1.setId(100L);
        Order update = repository.update(order1);

        assertNotEquals(update.getCreateData(), update.getUpdateData());
    }

    @Override
    Order createEntity() {
        return new Order();
    }
}
