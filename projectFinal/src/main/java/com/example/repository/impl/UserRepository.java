package com.example.repository.impl;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by ebastic on 11/23/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query("select u from user u where u.name = ?1 and u.password = ?2")
    //public List<String> findUserToAuth(String username);
    User findUserByName(String name);

}
