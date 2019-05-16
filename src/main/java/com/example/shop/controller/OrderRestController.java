package com.example.shop.controller;

import com.example.shop.controller.dto.OrderDto;
import com.example.shop.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

    private OrderServiceImpl service;

    @Autowired
    public OrderRestController(OrderServiceImpl orderService){
        this.service = orderService;
    }

    @RequestMapping( method = GET)
    public List<OrderDto> getAll() {
        return service.getAll();
    }
}
