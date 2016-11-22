package service.impl;

import domain.Item;
import domain.Lot;
import domain.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemRepository;
import repository.LotRepository;
import repository.UserRepository;
import service.api.AuctionService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */

@Setter
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;


    public Lot createLot(Item item, User owner, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(owner);
        lot.setStartPrice(startPrice);
        lot.setDatePlaced(new Date());
        lotRepository.save(lot);
        return lot;
    }

    public List<Lot> getActiveLots() {
        //TODO
        return (List<Lot>) lotRepository.findAll();
//                lotDAO.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<Item> getItems() {
        return (List<Item>) itemRepository.findAll();
    }

    public void createItem(Item item){
        itemRepository.save(item);
    }

    public void createUser(User user){
        userRepository.save(user);
    }
}
