package com.restaurants.service;

import com.restaurants.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);

    void delete(int id);

    Restaurant get(int id);

    Restaurant getByName(String name);

    List<Restaurant> getAll();

    List<Restaurant> getBetweenDates(LocalDate startDate, LocalDate endDate);

}
