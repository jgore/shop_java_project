package com.example.shop.controller;

import java.util.List;

public interface IController<D> {
    D get (Long id);

    List<D> getAll();

    D save(D d);

    D update(D d);

    D delete(D d);

}
