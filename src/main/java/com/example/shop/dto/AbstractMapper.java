package com.example.shop.dto;

import org.springframework.stereotype.Component;

@Component
public interface AbstractMapper<E, D> {

     E dtoToEntity(D d);
     D entityToDto(E e);
}
