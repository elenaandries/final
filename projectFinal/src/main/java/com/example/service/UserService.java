package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ebastic on 11/23/2016.
 */
@Service
public interface UserService {

    User create(User user);
    List<User> findAll();
    User update(User user);
    User findByCredentials(String username, String password);
    User findByName(String username);
}
