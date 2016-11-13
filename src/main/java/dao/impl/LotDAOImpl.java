package dao.impl;

import dao.api.LotDAO;
import domain.Lot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Tretiak Anton on 09.11.2016.
 */
@Component
public class LotDAOImpl implements LotDAO {
    private List<Lot> lots = new ArrayList<>();

    public List<Lot> getAll() {
        return new ArrayList<>(lots);
    }

    public void add(Lot entity) {
        lots.add(entity);
    }

    public void remove(Lot entity) {
        lots.remove(entity);
    }
}
