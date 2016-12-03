package com.example.service;

import com.example.model.City;
import com.example.model.User;
import com.example.repository.impl.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by ebastic on 11/24/2016.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public City create(City city) {
        City createdCity = city;
        return cityRepository.save(createdCity);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City update(City city, String cityName) {
        City updateCity = cityRepository.findOne(city.getId());
        if (updateCity == null)
            try {
                throw new Exception();
            } catch (Exception e) {
            }
        updateCity.setId(city.getId());
        updateCity.setName(city.getName());
        updateCity.setCountry(city.getCountry());

        return updateCity;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        City deletedCity = cityRepository.findOne(id);

        if (deletedCity == null)
            try {
                throw new Exception();
            } catch (Exception e) {
            }
        cityRepository.delete(deletedCity);
    }

    @Override
    public City findByName(City city) {
        return cityRepository.findOne(city.getId());
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findOne(id);
    }

}
