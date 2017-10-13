package com.restaurants.service;

import com.restaurants.model.Dish;
import com.restaurants.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
