package service.api;

import domain.Item;
import domain.Lot;
import domain.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Provides main functionality for Auction
 * Created by Tretiak Anton on 09.11.2016.
 */
public interface AuctionService {

    /**
     * Creates a Lot
     * @param item - item for auction
     * @param owner - user that starts auction
     * @param startPrice - item's start price
     * @return created lot
     */
    Lot createLot(Item item, User owner, BigDecimal startPrice);

    /**
     * Returns all lots that dont have end date yet
     * @return List of active lots
     */
    List<Lot> getActiveLots();

    /**
     * Returns all registered users
     * @return List of all users
     */
    List<User> getUsers();
}
