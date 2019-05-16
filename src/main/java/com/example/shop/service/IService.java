package com.example.shop.service;

import com.example.shop.entity.Identifable;

import java.util.List;

public interface IService<E extends Identifable, DTO> {
    DTO get(Long id);

    List<DTO> getAll();

    DTO save(DTO dto);

    DTO update(DTO dto);

    DTO delete(Long id);

    void deleteAll();
}
