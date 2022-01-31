package com.leoamorimr.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        User user = userDAOService.findOne(userId);
        if (user == null)
            throw new UserNotFoundException("id-" + userId);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDAOService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    private void deleteUser(@PathVariable int userId) {
        User user = userDAOService.deleteUserById(userId);
        if (user == null)
            throw new UserNotFoundException("id-" + userId);
    }


}
