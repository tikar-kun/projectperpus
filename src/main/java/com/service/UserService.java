package com.service;

import com.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registUser (User user);
    Optional<User> findByEmail (String email);
    List<User> findAll();

    Optional<User> findByPasswordAndEmail(String password, String email);

}
