package com.example.shop.controller;

import com.example.shop.controller.dto.ProductDto;
import com.example.shop.entity.Product;
import com.example.shop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController implements IController<Product, ProductDto> {

    private ProductServiceImpl service;

    @Autowired
    public ProductController(ProductServiceImpl ProductServiceImpl) {
        this.service = ProductServiceImpl;
    }

    @Override
    @RequestMapping(value = "/{id}",method = GET)
    public ProductDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @Override
    @RequestMapping( method = GET)
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @Override
    @RequestMapping(method = POST)
    public ProductDto save(@RequestBody Product Product) {
        return service.save(Product);
    }

    @Override
    @RequestMapping(method = PUT)
    public ProductDto update(@RequestBody Product Product) {
        return service.update(Product);
    }

    @Override
    @RequestMapping(value = "{id}", method = DELETE)
    public ProductDto delete(@PathVariable("id") Long id ) {
        return service.delete(id);
    }
}
