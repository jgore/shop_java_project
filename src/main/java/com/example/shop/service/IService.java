package com.example.shop.service;

import java.util.List;

public interface IService<E, D> {
    D get (Long id);

    List<D> getAll();

    E save(D d);

    E update(D d);

    E delete(D d);

    void deleteAll();
}
