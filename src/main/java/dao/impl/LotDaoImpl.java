package dao.impl;

import dao.api.LotDAO;
import domain.Lot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
public class LotDaoImpl implements LotDAO {
    private List<Lot> lots = new ArrayList<Lot>();

    public List<Lot> getAll() {
        return new ArrayList<Lot>(lots);
    }

    public void add(Lot entity) {
        lots.add(entity);
    }

    public void remove(Lot entity) {
        lots.remove(entity);
    }
}
