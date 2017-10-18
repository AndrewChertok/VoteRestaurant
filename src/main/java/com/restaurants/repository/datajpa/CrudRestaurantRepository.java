package com.restaurants.repository.datajpa;


import com.restaurants.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer>{

    @Transactional
    @Override
    Restaurant save(Restaurant restaurant);

    @Transactional
    @Override
    void deleteById(Integer id);

    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.menu WHERE r.id = :id")
    Restaurant getWithDishes(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r WHERE r.name = ?1")
    Restaurant getByName(String name);

    @Query("SELECT r FROM Restaurant r order by r.createdOrUpdated DESC ")
    List<Restaurant> getAll();

    @Query("SELECT r FROM Restaurant r WHERE r.createdOrUpdated BETWEEN :startDate AND :endDate ORDER BY r.createdOrUpdated DESC ")
    List<Restaurant> getBetweenDates(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant r set r.votes = ?1 WHERE r.id = ?2")
    void setVotes(Integer vote, Integer restId);

}
