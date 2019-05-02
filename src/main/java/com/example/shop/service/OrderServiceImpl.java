package com.example.shop.service;

import com.example.shop.controller.dto.OrderDto;
import com.example.shop.entity.Order;
import com.example.shop.mapper.Mapper;
import com.example.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order,OrderDto> implements OrderService<Order, OrderDto> {

    @Autowired
    public OrderServiceImpl(IRepository<Order> repository, Mapper<Order, OrderDto> mapper) {
        super(repository, mapper);
    }
}
