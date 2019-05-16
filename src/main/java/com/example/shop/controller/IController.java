package com.example.shop.controller;

import com.example.shop.entity.Identifable;

import java.util.List;

public interface IController<E extends Identifable, DTO> {
    DTO get(Long id);

    List<DTO> getAll();

    DTO save(DTO dto);

    DTO update(DTO d);

    DTO delete(Long id);

}
