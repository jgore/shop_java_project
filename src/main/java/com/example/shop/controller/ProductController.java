package com.example.shop.controller;

import com.example.shop.dto.ProductDto;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController implements IController<ProductDto> {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/{id}", method = GET)
    public ProductDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @Override
    @RequestMapping(value = "/getAll", method = GET)
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @Override
    @RequestMapping(method = POST)
    public ProductDto save(@RequestBody ProductDto productDto) {
        service.save(productDto);
        return productDto;
    }

    @Override
    @RequestMapping(method = PUT)
    public ProductDto update(@RequestBody ProductDto productDto) {
        service.update(productDto);
        return productDto;
    }

    @Override
    @RequestMapping(method = DELETE)
    public ProductDto delete(ProductDto productDto) {
        service.delete(productDto);
        return productDto;
    }
}
