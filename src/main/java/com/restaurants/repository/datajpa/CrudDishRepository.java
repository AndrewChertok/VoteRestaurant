package com.restaurants.repository.datajpa;

import com.restaurants.model.Dish;
import com.restaurants.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CrudDishRepository extends JpaRepository<Dish, Integer>{

    @Override
    Dish save(Dish dish);

    @Override
    void deleteById(Integer id);

    @Modifying
    @Query("UPDATE Dish d SET d.restaurant = ?1 WHERE d.id = ?2")
    void setRestaurant(Restaurant restaurant, Integer id);
}
