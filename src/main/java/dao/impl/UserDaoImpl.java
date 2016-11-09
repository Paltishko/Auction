package dao.impl;

import dao.api.UserDAO;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
public class UserDaoImpl implements UserDAO {
    private List<User> users = new ArrayList<User>();


    public List<User> getAll() {
        return new ArrayList<User>(users);
    }

    public void add(User entity) {
        users.add(entity);
    }

    public void remove(User entity) {
        users.remove(entity);
    }

    /**
     * Generates few users for testing purposes
     */
    public void generateTestUsers(){
        users.add(new User(1, "Paltishko", "Anton", "Tretiak"));
        users.add(new User(2, "Shoom", "John", "Smith"));
        users.add(new User(3, "Rambo", "Silvester", "Stallone"));
        users.add(new User(4, "T800", "Arnord", "Shwarcneger"));
        users.add(new User(5, "Tureckiy", "Jason", "Stethem"));
    }
}
