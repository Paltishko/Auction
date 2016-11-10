package dao.impl;

import dao.api.ItemDAO;
import domain.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
public class ItemDAOImpl implements ItemDAO {
    private List<Item> items = new ArrayList<>();

    public List<Item> getAll() {
        return new ArrayList<>(items);
    }

    public void add(Item entity) {
        items.add(entity);
    }

    public void remove(Item entity) {
        items.remove(entity);
    }
}
