package com.leoamorimr.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    private final UserDAOService userDAOService;

    public UserResource(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDAOService.findAll();
    }

    @GetMapping("/users/{userId}")
    private User retrieveUser(@PathVariable int userId) {
        return userDAOService.findOne(userId);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User savedUser = userDAOService.save(user);
    }


}
