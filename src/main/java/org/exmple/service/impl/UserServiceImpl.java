package org.exmple.service.impl;

import org.exmple.entity.Role;
import org.exmple.exception.InvalidInputException;
import org.exmple.model.User;
import org.exmple.repository.RoleRepository;
import org.exmple.repository.UserRepository;
import org.exmple.service.UserService;
import org.exmple.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ValidationService validationService;


    @Override
    public User createUser(User user) {
        if(this.validationService.validatePassword(user.getPassword())) {
            throw new InvalidInputException("Password does not match the required criteria");
        }
        return this.createUserResponse(
                userRepository.save(this.createUserEntity(user)));
    }

    @Override
    public User updateUser(String username, User user) {
        Assert.isTrue(username.equals(user.getUsername()),String.format("Invalid username: %s in the request.", username));
        Assert.isTrue(userRepository.existsById(username), String.format("Invalid username: %s", username));
        return this.createUserResponse(
                userRepository.save(this.createUserEntity(user)));
    }

    @Override
    public void deleteUser(String username) {
         this.userRepository.deleteById(username);
    }

    @Override
    public Optional<User> getUser(String username) {
        return Optional.ofNullable(this.createUserResponse(userRepository.findById(username).orElse(null)));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Iterator<org.exmple.entity.User> userIterator = userRepository.findAll().iterator();
        userIterator.forEachRemaining(user -> userList.add(this.createUserResponse(user)));
        return userList;
    }

    private User createUserResponse(org.exmple.entity.User user){
        if(Objects.isNull(user)) return null;
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .roleId(user.getRole().getRoleId())
                .build();
    }

    private org.exmple.entity.User createUserEntity(User user){
        Role role = roleRepository.findById(user.getRoleId()).orElse(null);
        return org.exmple.entity.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .role(role)
                .build();
    }

}
