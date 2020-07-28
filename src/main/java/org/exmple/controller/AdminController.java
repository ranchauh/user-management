package org.exmple.controller;

import lombok.extern.log4j.Log4j2;
import org.exmple.exception.NotFoundException;
import org.exmple.exception.ServiceException;
import org.exmple.model.User;
import org.exmple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manage")
@Log4j2
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping(name = "/user",produces = "application/json")
    public User createUser(@RequestBody User user) {
        try{
           return userService.createUser(user);
        }catch (Exception e){
            throw new ServiceException(String.format("Exception while creating user with username: %s",user.getUsername()),e);
        }
    }

    @GetMapping(name = "/user/{username}",produces = "application/json")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username)
                .map(user -> {
                    user.setPassword(null); return user;
                })
                .orElseThrow(() -> new NotFoundException(
                        String.format("User with username: %s not found", username)));

    }

    @GetMapping(value = "/user",produces = "application/json")
    public List<User> getAllUser() {
        return userService.getAllUsers()
                .stream()
                .peek(user -> user.setPassword(null))
                .collect(Collectors.toList());
    }

}
