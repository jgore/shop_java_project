package com.example.shop.repository;

import com.example.shop.entity.Identifable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AbstractRepository<T extends Identifable> implements IRepository<T> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    protected void setClazz(Class<T> classToSet) {
        this.clazz = classToSet;
    }

    @Override
    public T get(Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public void save(T t) {
        entityManager.persist(t);
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = entityManager.merge(t);
        entityManager.remove(t);
    }

    @Override
    public void deleteById(Long id) {
        T t = get(id);
        entityManager.remove(t);
    }

    @Override
    public void deleteAll() {
        List<T> all = getAll();
        all.forEach(e -> {
            entityManager.remove(e);
        });
    }
}
