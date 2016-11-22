package dao.impl;

import dao.api.LotDAO;
import domain.Lot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * Created by Tretiak Anton on 09.11.2016.
 */
@Repository
public class LotDAOImpl implements LotDAO {

    @PersistenceContext
    EntityManager em;

    public List<Lot> getAll() {
        return em.createQuery("SELECT l FROM Lot l").getResultList();
    }

    @Transactional
    public void add(Lot entity) {
        em.persist(entity);
    }

    @Transactional
    public void remove(Lot entity) {
        em.remove(entity);
    }
}
