package com.restaurants.repository.datajpa;

import com.restaurants.model.Dish;
import com.restaurants.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaDishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository repository;

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Dish> getAll(){
        return repository.findAll();
    }


    @Override
    public List<Dish> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.getBetweenDates(startDate, endDate);
    }

}
