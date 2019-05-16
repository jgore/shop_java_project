package com.example.shop.repository;

import com.example.shop.entity.Identifable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AbstractRepository<E extends Identifable> implements IRepository<E> {

    private Class<E> clazz;

    @PersistenceContext
    protected EntityManager em;


    protected void setClazz(Class<E> classToSet) {
        this.clazz = classToSet;
    }

    @Override
    public E get(Long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<E> getAll() {
        return em.createQuery("from " + clazz.getSimpleName() + " order by create_data desc")
                .getResultList();
    }

    @Override
    @Transactional
    public E save(E e) {
        em.persist(e);
        em.flush();
        return e;
    }

    @Override
    @Transactional
    public E update(E e) {
        em.merge(e);
        em.flush();
        return e;
    }

    @Override
    @Transactional
    public E delete(Long id) {
        E e = get(id);
        em.remove(e);
        return e;
    }

    @Override
    @Transactional
    public void deleteAll() {
        getAll().forEach($ -> em.remove($));
    }
}
