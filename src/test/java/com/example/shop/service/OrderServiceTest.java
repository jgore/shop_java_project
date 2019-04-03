package com.example.shop.service;

import com.example.shop.dto.OrderDto;
import com.example.shop.dto.OrderLineItemMapper;
import com.example.shop.dto.OrderMapper;
import com.example.shop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    OrderMapper mapper;

    @Mock
    OrderLineItemMapper orderLineItemMapper;

    @InjectMocks
    OrderServiceImpl service;

    @Test
    public void get() {
        service.get(1L);

        verify(orderRepository, times(1)).get(anyLong());
    }

    @Test
    public void save() {
        OrderDto dto = new OrderDto();
        service.save(dto);

        verify(orderRepository, times(1)).save(any());
    }

    @Test
    public void update() {
        OrderDto dto = new OrderDto();
        service.update(dto);

        verify(orderRepository, times(1)).update(any());
    }

    @Test
    public void delete() {
        OrderDto dto = new OrderDto();
        service.delete(dto);

        verify(orderRepository, times(1)).delete(any());
    }

    @Test
    public void deleteAll() {
        service.deleteAll();

        verify(orderRepository, times(1)).deleteAll();
    }

    @Test
    public void getAll() {
        service.getAll();

        verify(orderRepository, times(1)).getAll();
    }
}
