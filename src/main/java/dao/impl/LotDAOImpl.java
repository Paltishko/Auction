package dao.impl;

import dao.api.LotDAO;
import domain.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
/**
 * Created by Tretiak Anton on 09.11.2016.
 */
@Component
public class LotDAOImpl implements LotDAO {

    @Autowired
    EntityManagerFactory emf;

    public List<Lot> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT l FROM Lot l").getResultList();
    }

    @Transactional
    public void add(Lot entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(entity);
        transaction.commit();
        em.close();
    }

    @Transactional
    public void remove(Lot entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(entity);
        transaction.commit();
        em.close();
    }
}
