package com.example.service;

import com.example.model.City;
import com.example.model.CityCache;
import org.springframework.stereotype.Service;

/**
 * Created by ebastic on 12/4/2016.
 */
@Service
public interface CityCacheService  {

    CityCache findById(Long id);
    CityCache create(CityCache city);
    void deleteCache(Long id);
}
