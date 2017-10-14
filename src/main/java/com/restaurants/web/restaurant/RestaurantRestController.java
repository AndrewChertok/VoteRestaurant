package com.restaurants.web.restaurant;

import com.restaurants.model.Restaurant;
import com.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static com.restaurants.web.restaurant.RestaurantRestController.URL;

@Controller
@RequestMapping(URL)
public class RestaurantRestController {

    static final String URL = "/restaurants";

    @Autowired
    private RestaurantService restaurantService;

   @GetMapping
    public Collection<Restaurant> getAll(){
        return  restaurantService.getAll();
    }


    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant save(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }



    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant update(@RequestBody Restaurant restaurant) {
        return restaurantService.update(restaurant);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        restaurantService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable("id") int id) {
        return restaurantService.get(id);
    }

    @GetMapping(value = "/{name}")
    public Restaurant getByName(@PathVariable("name")String name){
        return restaurantService.getByName(name);
    }


    @GetMapping(value = "/filter")
    public  List<Restaurant> getBetweenDates(
            @RequestParam(value = "from", required = false) LocalDate startDate,
            @RequestParam(value = "to", required = false)  LocalDate endDate) {
        return restaurantService.getBetweenDates(startDate, endDate);
    }
}
