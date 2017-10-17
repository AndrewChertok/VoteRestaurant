package com.restaurants.web.dish;

import com.restaurants.model.Dish;
import com.restaurants.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.time.LocalDate;
import java.util.List;

@Controller
public abstract class AbstractDishController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishService dishService;

    public Dish save(Dish dish){
        log.info("create {}", dish);
        return dishService.save(dish);
    }

    public Dish update(Dish dish) {
        log.info("update {}", dish);
        return dishService.update(dish);
    }


    public void delete(Integer id){
        log.info("delete {}", id);
        dishService.delete(id);
    }


    public Dish getById(Integer id){
        log.info("getById {}", id);
        return dishService.getById(id);
    }


    public List<Dish> getAll(){
        log.info("getAll");
        return dishService.getAll();
    }


    public List<Dish> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        log.info("getBetweenDates {}",startDate, endDate);
        return dishService.getBetweenDates(startDate, endDate);
    }
}
