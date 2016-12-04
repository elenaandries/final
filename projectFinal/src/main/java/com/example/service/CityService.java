package com.example.service;

import com.example.model.City;
import com.example.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by ebastic on 11/24/2016.
 */
@Service
public interface CityService {

    City create(City city);
    List<City> findAll();
    City update(City city, String cityName);
    void delete(Long id);
    City findByName(City city);
    City findById(Long id);
}
