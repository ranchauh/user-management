package org.exmple.controller;

import lombok.extern.log4j.Log4j2;
import org.exmple.model.LoginDetails;
import org.exmple.model.User;
import org.exmple.service.LoginService;
import org.exmple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    /**
     * Endpoint for user login.
     * @param loginDetails
     */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void login(@RequestBody LoginDetails loginDetails){
        loginService.login(loginDetails);
    }

    /**
     * Endpoint to allow users to update user details.
     * @param username
     * @param user
     */
    @PutMapping( name = "/{username}",produces = "application/json")
    public User update(@PathVariable("username") String username,
                       @RequestBody User user){
        return userService.updateUser(username,user);
    }

}
