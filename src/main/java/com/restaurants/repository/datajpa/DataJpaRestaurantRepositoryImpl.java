package com.restaurants.repository.datajpa;

import com.restaurants.model.Restaurant;
import com.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository restaurantRepository;


    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(int id) {
       restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant get(int id) {
        return restaurantRepository.getWithDishes(id);
    }

    @Override
    public Restaurant getByName(String name) {
        return restaurantRepository.getByName(name);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }

    @Override
    public List<Restaurant> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return restaurantRepository.getBetweenDates(startDate, endDate);
    }

    public void setVotes(Integer vote, Integer restId){
        restaurantRepository.setVotes(vote, restId);
    }
}
