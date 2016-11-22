package dao.impl;

import dao.api.ItemDAO;
import domain.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */

@Repository
public class ItemDAOImpl implements ItemDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Item> getAll() {
        return em.createQuery("SELECT i FROM Item i").getResultList();
    }

    @Transactional
    public void add(Item entity) {
        em.persist(entity);
    }

    @Transactional
    public void remove(Item entity) {
        em.remove(entity);
    }
}
