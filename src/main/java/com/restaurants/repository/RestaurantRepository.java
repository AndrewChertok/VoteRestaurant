package com.restaurants.repository;

import com.restaurants.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    void delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();

    List<Restaurant> getBetweenDates(LocalDate startDate, LocalDate endDate);

    default  void setVotes(Integer vote, Integer restId){

    }

   default Restaurant getByName(String name){
        return null;
    }

    default void setCreated(LocalDate created, Integer id){

    }

}
