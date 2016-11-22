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

        generateSomeItems(auctionService);
        generateSomeUsers(auctionService);

        List<User> users = auctionService.getUsers();
        List<Item> items = auctionService.getItems();

        generateSomeLots(auctionService, users,items);

        System.out.println(users);
        System.out.println(items);
        System.out.println(auctionService.getActiveLots());
    }

    private static void generateSomeLots(AuctionService auctionService, List<User> users, List<Item> items) {
        auctionService.createLot(items.get(0), users.get(0), BigDecimal.ONE);
        auctionService.createLot(items.get(1), users.get(1), BigDecimal.ONE);
        auctionService.createLot(items.get(2), users.get(2), BigDecimal.ONE);
        auctionService.createLot(items.get(3), users.get(3), BigDecimal.ONE);
        auctionService.createLot(items.get(4), users.get(4), BigDecimal.ONE);
    }

    private static void generateSomeItems(AuctionService auctionService) {
        Item item = new Item();
        item.setTitle("NoteBook");
        item.setDescription("Asus");
        auctionService.createItem(item);

        item = new Item();
        item.setTitle("Phone");
        item.setDescription("Nokia");
        auctionService.createItem(item);

        item = new Item();
        item.setTitle("Sofa");
        item.setDescription("IKEA");
        auctionService.createItem(item);

        item = new Item();
        item.setTitle("Car");
        item.setDescription("Ford");
        auctionService.createItem(item);

        item = new Item();
        item.setTitle("Plane");
        item.setDescription("Cesna");
        auctionService.createItem(item);
    }


    private static void generateSomeUsers(AuctionService auctionService) {
        User user = new User();
        user.setLogin("Paltishko");
        user.setFirstName("Anton");
        user.setFirstName("Tretiak");
        auctionService.createUser(user);

        user = new User();
        user.setLogin("Shoom");
        user.setFirstName("John");
        user.setFirstName("Smith");
        auctionService.createUser(user);

        user = new User();
        user.setLogin("Rambo");
        user.setFirstName("Silvester");
        user.setFirstName("Stallone");
        auctionService.createUser(user);

        user = new User();
        user.setLogin("T800");
        user.setFirstName("Arnord");
        user.setFirstName("Shwarcneger");
        auctionService.createUser(user);

        user = new User();
        user.setLogin("Tureckiy");
        user.setFirstName("Jason");
        user.setFirstName("Stethem");
        auctionService.createUser(user);
    }
}
