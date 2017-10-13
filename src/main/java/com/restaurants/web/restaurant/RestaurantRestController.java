package com.restaurants.web.restaurant;

import com.restaurants.model.Restaurant;
import com.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;


@Controller
public class RestaurantRestController {

    @Autowired
    @Qualifier("restaurantService")
    private RestaurantService service;

    
    public Restaurant save(Restaurant restaurant) {
        return service.save(restaurant);
    }

    
    public Restaurant update(Restaurant restaurant) {
        return service.update(restaurant);
    }
    
    public void delete(int id) {
         service.delete(id);
    }

    public Restaurant get(int id) {
        return service.get(id);
    }

    public Restaurant getByName(String name){
        return service.getByName(name);
    }

    
    public List<Restaurant> getAll() {
        return service.getAll();
    }

   public  List<Restaurant> getBetweenDates(LocalDate startDate, LocalDate endDate) {
       return service.getBetweenDates(startDate, endDate);
   }


}
