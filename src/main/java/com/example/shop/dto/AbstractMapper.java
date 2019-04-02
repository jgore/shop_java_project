package com.example.shop.dto;

public interface AbstractMapper<E, D> {

     E dtoToEntity(D d);
     D entityToDto(E e);
}
