package dao.impl;

import dao.api.UserDAO;
import domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager em;

    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Transactional
    public void add(User entity) {
        em.persist(entity);
    }

    @Transactional
    public void remove(User entity) {
        em.remove(entity);
    }
}
