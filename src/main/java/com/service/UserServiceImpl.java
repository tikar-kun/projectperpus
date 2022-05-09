package com.service;

import com.model.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepository userRepository;

    @Override
    public User registUser(User user){
        User entity = userRepository.save(user);
        return userRepository.save(entity);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll(){
        return  userRepository.findAll();
    }

    @Override
    public Optional<User> findByPasswordAndEmail(String password, String email){
        return userRepository.findByPasswordAndEmail(password, email);
    }
}

