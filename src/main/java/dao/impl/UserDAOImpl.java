package dao.impl;

import dao.api.UserDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManagerFactory emf;

    public List<User> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Transactional
    public void add(User entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.merge(entity);
        transaction.commit();
        em.close();
    }

    @Transactional
    public void remove(User entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(entity);
        transaction.commit();
        em.close();
    }

    /**
     * Generates few users for testing purposes
     */
    @Transactional
    @PostConstruct
    public void generateTestUsers(){
        add(new User(1, "Paltishko", "Anton", "Tretiak"));
        add(new User(2, "Shoom", "John", "Smith"));
        add(new User(3, "Rambo", "Silvester", "Stallone"));
        add(new User(4, "T800", "Arnord", "Shwarcneger"));
        add(new User(5, "Tureckiy", "Jason", "Stethem"));
    }
}
