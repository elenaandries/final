package com.example.repository.impl;

import com.example.model.City;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ebastic on 11/24/2016.
 */
public interface CityRepository extends JpaRepository<City, Integer> {
}
