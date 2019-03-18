package com.example.shop.mapper;

import com.example.shop.entity.Identifable;

public interface Mapper<E extends Identifable,DTO> {

     E map(DTO dto);

     DTO map(E entity) ;
}
