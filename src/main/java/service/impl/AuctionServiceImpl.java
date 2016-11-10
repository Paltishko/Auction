package service.impl;

import dao.api.LotDAO;
import dao.api.UserDAO;
import domain.Item;
import domain.Lot;
import domain.User;
import lombok.Setter;
import service.api.AuctionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */

@Setter
public class AuctionServiceImpl implements AuctionService {

    private LotDAO lotDAO;
    private UserDAO userDAO;


    public Lot createLot(Item item, User owner, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setId(lotDAO.getAll().size() + 1);
        lot.setItem(item);
        lot.setOwner(owner);
        lot.setStartPrice(startPrice);
        lotDAO.add(lot);
        return lot;
    }

    public List<Lot> getActiveLots() {
        return lotDAO.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return userDAO.getAll();
    }
}
