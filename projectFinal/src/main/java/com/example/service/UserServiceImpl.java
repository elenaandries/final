package com.example.service;

import com.example.model.User;
import com.example.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by ebastic on 11/23/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        User createdUser = user;
        return userRepository.save(createdUser);
    }

    @Override
    @Transactional
    public List findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(User user) {
        User updatedUser = userRepository.findOne(user.getId());
        if (updatedUser == null)
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.getPassword());
        return updatedUser;
    }

    @Override
    @Transactional
    public User findByCredentials(String username, String password) {
        return null;
    }

    @Override
    public User findByName(String username) {
        return userRepository.findUserByName(username);
    }

}
