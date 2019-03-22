package com.example.shop.service;

import com.example.shop.dto.AbstractMapper;
import com.example.shop.entity.Identifable;
import com.example.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class AbstractService<E extends Identifable, D> implements IService<E, D> {

    private IRepository<E> repository;
    private AbstractMapper<E, D> abstractMapper;

    @Autowired
    public AbstractService(IRepository<E> repository, AbstractMapper<E, D> abstractMapper) {
        this.repository = repository;
        this.abstractMapper = abstractMapper;
    }

    @Override
    public D get(Long id) {
        E e = repository.get(id);
        return abstractMapper.entityToDto(e);
    }

    @Override
    public List<D> getAll() {
        List<E> all = repository.getAll();
        List<D> allDtos = all.stream()
                .map(e -> abstractMapper.entityToDto(e))
                .collect(Collectors.toList());
        return allDtos;
    }

    @Override
    public E save(D d) {
        E e = abstractMapper.dtoToEntity(d);
        return repository.save(e);
    }

    @Override
    public E update(D d) {
        E e = abstractMapper.dtoToEntity(d);
        return repository.update(e);
    }

    @Override
    public E delete(D d) {
        E e = abstractMapper.dtoToEntity(d);
        return repository.delete(e);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
