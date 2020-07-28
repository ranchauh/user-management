package org.exmple.service.impl;

import org.exmple.service.ValidationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Value("${password.check.regex:^((?=.*\\d)(?=.*[A-Za-z])(?=.*\\W).{8,50})$}")
    private String passwordMatchRegex;

    @Override
    public boolean validatePassword(String password) {
        return Objects.nonNull(password) &&
                passwordMatchRegex.matches(password);
    }
}
