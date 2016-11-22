package service.impl;

import dao.api.ItemDAO;
import dao.api.LotDAO;
import dao.api.UserDAO;
import domain.Item;
import domain.Lot;
import domain.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.api.AuctionService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */

@Setter
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private LotDAO lotDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ItemDAO itemDAO;



    public Lot createLot(Item item, User owner, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(owner);
        lot.setStartPrice(startPrice);
        lot.setDatePlaced(new Date());
        lotDAO.add(lot);
        return lot;
    }

    public List<Lot> getActiveLots() {
        return lotDAO.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return userDAO.getAll();
    }

    public List<Item> getItems() {
        return itemDAO.getAll();
    }

    public void createItem(Item item){
        itemDAO.add(item);
    }

    public void createUser(User user){
        userDAO.add(user);
    }
}
