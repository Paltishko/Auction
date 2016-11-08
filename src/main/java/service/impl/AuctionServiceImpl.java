package service.impl;

import domain.Item;
import domain.Lot;
import domain.User;
import service.api.AuctionService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
public class AuctionServiceImpl implements AuctionService {
    public Lot createLot(Item item, User owner, BigDecimal startPrice) {
        return null;
    }

    public List<Lot> getActiveLots() {
        return null;
    }

    public List<User> getUsers() {
        return null;
    }
}
