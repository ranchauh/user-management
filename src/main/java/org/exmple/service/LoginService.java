package org.exmple.service;

import org.exmple.model.LoginDetails;

public interface LoginService {
    void login(LoginDetails loginDetails);
    void logout(String username);
}
