package com.example.shop.controller;

import java.util.List;

public interface IController<E> {
    E get (Long id);

    List<E> getAll();

    E save(E e);

    E update(E e);

    E delete(E e);

}
