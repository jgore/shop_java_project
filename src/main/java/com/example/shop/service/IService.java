package com.example.shop.service;

import java.util.List;

public interface IService<E> {
    E get (Long id);

    List<E> getAll();

    E save(E e);

    E update(E e);

    E delete(E e);

    void deleteAll();
}
