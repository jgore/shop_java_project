package com.example.shop.dto;

import com.example.shop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements AbstractMapper<Product, ProductDto>

{
    @Override
    public Product dtoToEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(productDto.getCategory());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return product;
    }

    @Override
    public ProductDto entityToDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setCategory(product.getCategory());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }
}
