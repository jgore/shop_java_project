package com.example.shop.service;

import com.example.shop.entity.Identifable;

import java.util.List;

public interface IService<E extends Identifable,DTO> {
    DTO get (Long id);

    List<DTO> getAll();

    DTO save(E e);

    DTO update(E e);

    DTO delete(Long id);

    void deleteAll();
}
