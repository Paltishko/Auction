package dao.impl;

import dao.api.UserDAO;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tretiak Anton on 09.11.2016.
 */
public class UserDaoImpl implements UserDAO {
    private List<User> users;


    public List getAll() {
        return new ArrayList<User>(users);
    }

    public void add(User entity) {
        users.add(entity);
    }

    public void remove(User entity) {
        users.remove(entity);
    }
}
