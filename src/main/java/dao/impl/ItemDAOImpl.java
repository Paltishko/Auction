package dao.impl;

import dao.api.ItemDAO;
import domain.Item;
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
public class ItemDAOImpl implements ItemDAO {
    @Autowired
    EntityManagerFactory emf;

    public List<Item> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT i FROM Item i").getResultList();
    }

    @Transactional
    public void add(Item entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(entity);
        transaction.commit();
        em.close();
    }

    @Transactional
    public void remove(Item entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(entity);
        transaction.commit();
        em.close();
    }

    @Transactional
    @PostConstruct
    public void generateTestItems(){
        Item item = new Item();
        item.setTitle("NoteBook");
        item.setDescription("Asus");
        add(item);

        item = new Item();
        item.setTitle("Phone");
        item.setDescription("Nokia");
        add(item);

        item = new Item();
        item.setTitle("Sofa");
        item.setDescription("IKEA");
        add(item);

        item = new Item();
        item.setTitle("Car");
        item.setDescription("Ford");
        add(item);

        item = new Item();
        item.setTitle("Plane");
        item.setDescription("Cesna");
        add(item);
    }
}
