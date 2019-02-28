package com.example.shop.repository;

import java.util.List;

public interface IRepository<E> {
    E get (Long id);

    List<E> getAll();

    E save(E e);

    E update(E e);

    E delete(E e);

    void deleteAll();

}
