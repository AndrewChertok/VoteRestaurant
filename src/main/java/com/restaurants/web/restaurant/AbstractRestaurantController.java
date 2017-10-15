package com.restaurants.web.restaurant;

import com.restaurants.model.Restaurant;
import com.restaurants.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;


@Controller
public class AbstractRestaurantController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    
    public Restaurant save(Restaurant restaurant) {
        log.info("save {}", restaurant);
        return restaurantService.save(restaurant);
    }

    
    public Restaurant update(Restaurant restaurant) {
        log.info("update {}", restaurant);
        return restaurantService.update(restaurant);
    }
    
    public void delete(int id) {
        log.info("delete {}", id);
         restaurantService.delete(id);
    }

    public Restaurant get(int id) {
        log.info("get {}", id);
        return restaurantService.get(id);
    }

    public Restaurant getByName(String name){
        log.info("getByName {}", name);
        return restaurantService.getByName(name);
    }

    
    public List<Restaurant> getAll() {
        log.info("getAll");
        return restaurantService.getAll();
    }

   public  List<Restaurant> getBetweenDates(LocalDate startDate, LocalDate endDate) {
       log.info("getBetweenDates {}", startDate, endDate);
       return restaurantService.getBetweenDates(startDate, endDate);
   }


}
