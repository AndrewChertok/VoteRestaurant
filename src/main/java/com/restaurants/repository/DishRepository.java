package com.restaurants.repository;

import com.restaurants.model.Dish;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository {

    Dish save(Dish dish);

    void delete(Integer id);

    Dish getById(Integer id);

    List<Dish> getAll();

    List<Dish> getBetweenDates(LocalDate startDate, LocalDate endDate);

}
