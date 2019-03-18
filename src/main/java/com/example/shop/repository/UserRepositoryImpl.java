package com.example.shop.repository;

import com.example.shop.entity.Account;
import com.example.shop.entity.User;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    public UserRepositoryImpl() {
        setClazz(User.class);
    }

    @Override
    public User getByLogin(String login) {
        Query query = em.createQuery("from User user  where login=:login");
        query.setParameter("login", login);
        return  (User) query.getSingleResult();

    }

    @Override
    @Transactional
    public User save(User user) {
        Account account = new Account();
        user.setAccount(account);
        super.save(user);

        return getByLogin(user.getLogin());
    }


    @Override
    @Transactional
    public User update(User user) {

        User persistedUser = get(user.getId());

        user.setAccount(persistedUser.getAccount());

        em.merge(user);
        em.flush();
        return user;

    }




  /*  @Override
    @Transactional
    public User save(User user) {
        super.save(user);

        Query query = em.createQuery("from User user  where login=:login ");
        query.setParameter("login", user.getLogin());
        User userPersisted =  (User) query.getSingleResult();
        Account account = new Account();
        account.setUser(userPersisted);

        accountRepository.save(account);
        return getByLogin(user.getLogin());
    }

    @Override
    public User getByLogin(String login) {
        Query query = em.createQuery("from User user join user.account where login=:login ");
        query.setParameter("login", login);
        Object singleResult = query.getSingleResult();

    }*/
}
