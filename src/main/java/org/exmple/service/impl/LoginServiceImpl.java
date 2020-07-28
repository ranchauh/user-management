package org.exmple.service.impl;

import org.exmple.exception.UnauthorizedException;
import org.exmple.model.LoginDetails;
import org.exmple.model.User;
import org.exmple.service.LoginService;
import org.exmple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public void login(LoginDetails loginDetails) {
        User user = userService.getUser(loginDetails.getUsername())
                .orElseThrow(() ->new UnauthorizedException("Invalid username or password")
                        );
        if(!user.getPassword().equals(loginDetails.getPassword())){
            throw new UnauthorizedException("Invalid username or password");
        }
    }

    @Override
    public void logout(String username) {
        // To be implemented
    }
}
