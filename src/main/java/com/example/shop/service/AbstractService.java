package com.example.shop.service;

import com.example.shop.entity.Identifable;
import com.example.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbstractService<E extends Identifable> implements IService<E> {

    private IRepository<E> repository;

    @Autowired
    public AbstractService(@Qualifier("abstractRepository") IRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public E get(Long id) {
        return repository.get(id);
    }

    @Override
    public List<E> getAll() {
        return repository.getAll();
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public E delete(E e) {
        return repository.delete(e);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
