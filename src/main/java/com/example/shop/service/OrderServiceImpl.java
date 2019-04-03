package com.example.shop.service;

import com.example.shop.dto.OrderDto;
import com.example.shop.dto.OrderMapper;
import com.example.shop.entity.Order;
import com.example.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order, OrderDto> implements OrderService {

    private OrderRepository repository;
    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, OrderMapper orderMapper) {
        super(repository, orderMapper);
    }
}
