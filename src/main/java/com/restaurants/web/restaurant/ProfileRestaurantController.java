package com.restaurants.web.restaurant;

import com.restaurants.model.Restaurant;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(ProfileRestaurantController.URL)
public class ProfileRestaurantController extends AbstractRestaurantController {

    static final String URL = "/restaurant/profile";


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        return  super.getAll();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getByName(@RequestParam("name") String name){
        return super.getByName(name);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<Restaurant> getBetweenDates(
            @RequestParam(value = "from", required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return super.getBetweenDates(startDate, endDate);
    }
}
