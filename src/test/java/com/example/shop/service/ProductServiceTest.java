package com.example.shop.service;

import com.example.shop.controller.dto.ProductDto;
import com.example.shop.entity.Product;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setup() {
        when(productMapper.map(any(Product.class))).thenReturn(new ProductDto());
        when(productMapper.map(any(ProductDto.class))).thenReturn(new Product());
        when(repository.get(anyLong())).thenReturn(new Product());
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void get() {
        productService.get(1L);

        verify(repository, times(1)).get(anyLong());
    }

    @Test
    public void save() {
        ProductDto dto = new ProductDto();
        productService.save(dto);

        verify(repository, times(1)).save(any());
    }

    @Test
    public void getAll() {
        productService.getAll();
        verify(repository, times(1)).getAll();
    }

    @Test
    public void update() {
        ProductDto dto = new ProductDto();
        productService.update(dto);
        verify(repository, times(1)).update(any());
    }

    @Test
    public void delete() {
        Product Product = createProduct();
        productService.delete(Product.getId());

        verify(repository, times(1)).delete(any());
    }

    @Test
    public void deleteAll() {
        productService.deleteAll();

        verify(repository, times(1)).deleteAll();
    }

    private Product createProduct() {
        return new Product();
    }


}
