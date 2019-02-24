package com.example.shop.repository;

import java.util.List;

public interface IRepository<E> {

    E get (Long id);

    List<E> getAll();

    void save(E e);

    E update(E e);

    void delete(E e);

    void deleteById(Long id);

    void deleteAll();


}
