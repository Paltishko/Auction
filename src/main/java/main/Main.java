package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.AuctionService;

/**
 * Created by Tretiak Anton on 10.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("service-beans.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);

        System.out.println(auctionService.getUsers());
    }
}
