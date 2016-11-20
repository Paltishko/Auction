package main;

import domain.Item;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.AuctionService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tretiak Anton on 10.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("service-beans.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);


        List<User> users = auctionService.getUsers();
        List<Item> items = auctionService.getItems();

        auctionService.createLot(items.get(0), users.get(0), BigDecimal.ONE);
        auctionService.createLot(items.get(1), users.get(1), BigDecimal.ONE);
        auctionService.createLot(items.get(2), users.get(2), BigDecimal.ONE);
        auctionService.createLot(items.get(3), users.get(3), BigDecimal.ONE);
        auctionService.createLot(items.get(4), users.get(4), BigDecimal.ONE);
        System.out.println(users);
        System.out.println(items);
        System.out.println(auctionService.getActiveLots());

    }
}
