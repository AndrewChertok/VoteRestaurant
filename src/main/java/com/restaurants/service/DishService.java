package com.restaurants.service;

import com.restaurants.model.Dish;

public interface DishService {

    Dish save(Dish dish);

    void delete(Integer id);
}
