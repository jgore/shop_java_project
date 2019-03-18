package com.example.shop.service;

import com.example.shop.entity.Identifable;

public interface ProductService <E extends Identifable,DTO> extends IService<E,DTO> {

}
