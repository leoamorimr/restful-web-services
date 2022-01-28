package com.leoamorimr.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Leonardo", new Date()));
        users.add(new User(2, "Thayse", new Date()));
        users.add(new User(3, "Alice", new Date()));
    }

    private static int usersCount = 3;

    public List<User> findAll() {
        return users;
    }

    public User findOne(@PathVariable int userId) {
        for (User user : users) {
            if (user.getId() == userId)
                return user;
        }
        return null;
    }

    public User save(User user) {
        if (user.getId() == null)
            user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
