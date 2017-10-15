package com.restaurants.web.dish;


import com.restaurants.model.Dish;
import com.restaurants.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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


}
