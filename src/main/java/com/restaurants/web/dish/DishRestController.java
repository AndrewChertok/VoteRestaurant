package com.restaurants.web.dish;

import com.restaurants.model.Dish;
import com.restaurants.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DishRestController {

    @Autowired
    private DishService service;

   public Dish save(Dish dish){
      return service.save(dish);
    }

   public void delete(Integer id){
       service.delete(id);
    }


    public Dish getById(Integer id) {
        return service.getById(id);
    }


    public List<Dish> getAll() {
        return service.getAll();
    }


    public List<Dish> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return service.getBetweenDates(startDate, endDate);
    }
}
