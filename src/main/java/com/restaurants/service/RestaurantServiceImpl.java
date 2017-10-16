package com.restaurants.service;

import com.restaurants.model.Restaurant;
import com.restaurants.repository.RestaurantRepository;
import com.restaurants.repository.datajpa.DataJpaRestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    @Qualifier("jpaRestaurantRepository")
    private RestaurantRepository repository;

    public void setRepository(DataJpaRestaurantRepositoryImpl repository) {
        this.repository = repository;
    }


    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) {
         repository.delete(id);
    }

    @Override
    public Restaurant get(int id) {
        return repository.get(id);
    }

    @Override
    public Restaurant getByName(String name){
      return  repository.getByName(name);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Restaurant> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.getBetweenDates(startDate, endDate);
    }

    @Override
    public void setCreated(LocalDate created, Integer id) {
        repository.setCreated(created, id);
    }
}
