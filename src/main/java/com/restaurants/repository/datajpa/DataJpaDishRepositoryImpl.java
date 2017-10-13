package com.restaurants.repository.datajpa;

import com.restaurants.model.Dish;
import com.restaurants.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaDishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository repository;

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
