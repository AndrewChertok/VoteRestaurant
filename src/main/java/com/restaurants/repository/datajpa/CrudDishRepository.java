package com.restaurants.repository.datajpa;

import com.restaurants.model.Dish;
import com.restaurants.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer>{

    @Transactional
    @Override
    Dish save(Dish dish);

    @Transactional
    @Override
    void deleteById(Integer id);

    @Query("SELECT d FROM Dish d WHERE d.id = ?1")
    Dish getById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Dish d SET d.restaurant = ?1 WHERE d.id = ?2")
    void setRestaurant(Restaurant restaurant, Integer id);

    @Query("SELECT d FROM Dish d order by d.createdOrUpdated DESC ")
    List<Dish> findAll();

    @Query("SELECT d FROM Dish d WHERE d.createdOrUpdated BETWEEN :startDate AND :endDate ORDER BY d.createdOrUpdated DESC ")
    List<Dish> getBetweenDates(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);
}
