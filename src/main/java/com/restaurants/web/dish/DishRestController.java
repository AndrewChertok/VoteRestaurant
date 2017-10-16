package com.restaurants.web.dish;


import com.restaurants.model.Dish;
import com.restaurants.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DishRestController {

    @Autowired
    private DishService dishService;


    public Dish save(Dish dish){
        return dishService.save(dish);
    }

    public void delete(Integer id){
        dishService.delete(id);
    }

    public Dish getById(Integer id){
        return dishService.getById(id);
    }

    public List<Dish> getAll(){
        return dishService.getAll();
    }

    public List<Dish> getBetweenDates(LocalDate startDate, LocalDate endDate){
        return dishService.getBetweenDates(startDate, endDate);
    }


}
