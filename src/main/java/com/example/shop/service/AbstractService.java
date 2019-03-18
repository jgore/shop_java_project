package com.example.shop.service;

import com.example.shop.entity.Identifable;
import com.example.shop.mapper.Mapper;
import com.example.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class AbstractService<E extends Identifable, DTO> implements IService<E, DTO> {

    private IRepository<E> repository;
    private Mapper<E, DTO> mapper;

    @Autowired
    public AbstractService(@Qualifier("abstractRepository") IRepository<E> repository, Mapper<E, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DTO get(Long id) {
        E entity = repository.get(id);
        if (entity == null) {
            throw new IllegalArgumentException("User does not exist");
        }
        return mapper.map(entity);
    }

    @Override
    public List<DTO> getAll() {
        return repository.getAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public DTO save(E e) {
        return mapper.map(repository.save(e));
    }

    @Override
    public DTO update(E e) {
        return mapper.map(repository.update(e));
    }

    @Override
    public DTO delete(Long id) {
        return mapper.map(repository.delete(id));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
