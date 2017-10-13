package com.restaurants.web.dish;

import com.restaurants.model.Dish;
import com.restaurants.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DishController {

    @Autowired
    private DishService service;

   public Dish save(Dish dish){
      return service.save(dish);
    }

   public void delete(Integer id){
       service.delete(id);
    }
}
