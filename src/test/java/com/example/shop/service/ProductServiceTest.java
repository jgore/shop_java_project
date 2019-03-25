package com.example.shop.service;

import com.example.shop.dto.ProductDto;
import com.example.shop.dto.ProductMapper;
import com.example.shop.repository.ProductRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductMapper productMapper;

    @InjectMocks
    ProductServiceImpl productService;


    @After
    public void tearDown() throws Exception {
        productRepository.deleteAll();
    }

    @Test
    public void get() {
        productService.get(1L);

        verify(productRepository, times(1)).get(anyLong());
    }

    @Test
    public void save() {
        ProductDto dto = createProductDto();
        productService.save(dto);

        verify(productRepository, times(1)).save(Mockito.any());
    }

    @Test
    public void update() {
        ProductDto dto = createProductDto();
        productService.update(dto);

        verify(productRepository, times(1)).update(any());
    }

    @Test
    public void getAll() {
        productService.getAll();

        verify(productRepository, times(1)).getAll();
    }

    @Test
    public void deleteAll() {
        productService.deleteAll();

        verify(productRepository, times(1)).deleteAll();
    }

    @Test
    public void delete() {
        ProductDto dto = createProductDto();
        productService.delete(dto);

        verify(productRepository, times(1)).delete(any());
    }

    private ProductDto createProductDto() {
        return new ProductDto();
    }

}
