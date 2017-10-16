package com.restaurants.service;

import com.restaurants.model.Dish;
import com.restaurants.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private  DishRepository repository;


    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }


    @Override
    public Dish getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<Dish> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Dish> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.getBetweenDates(startDate, endDate);
    }

}
