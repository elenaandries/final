package com.example.service;

import com.example.model.CityCache;
import com.example.repository.impl.CityCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ebastic on 12/4/2016.
 */
@Service
public class CityCacheServiceImpl implements CityCacheService {

    @Autowired
    private CityCacheRepository cityCacheRepository;

    @Override
    @Transactional
    public CityCache findById(Long id) {
        return cityCacheRepository.findOne(id);
    }

    @Override
    @Transactional
    public CityCache create(CityCache city) {
        return cityCacheRepository.save(city);
    }

    @Override
    public void deleteCache(Long id) {
        CityCache deletedCache = cityCacheRepository.findOne(id);

        if (deletedCache == null)
            try {
                throw new Exception();
            } catch (Exception e) {
            }
        cityCacheRepository.delete(deletedCache);
    }

}
