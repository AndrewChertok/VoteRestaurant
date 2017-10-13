package com.restaurants.repository;

import com.restaurants.model.Dish;

public interface DishRepository {

    Dish save(Dish dish);

    void delete(Integer id);
}
