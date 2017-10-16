package com.restaurants.web.restaurant;

import com.restaurants.model.Restaurant;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(AdminRestaurantController.URL)
public class AdminRestaurantController extends AbstractRestaurantController{

    static final String URL = "/admin/restaurants";


   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        return  super.getAll();
    }


    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> adminSave(@RequestBody Restaurant restaurant) {

        Restaurant newRestaurant = super.save(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(newRestaurant.getId()).toUri();

          return ResponseEntity.created(uriOfNewResource).body(newRestaurant);
    }


    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> adminUpdate(@RequestBody Restaurant restaurant) {
        Restaurant updated = super.update(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(updated.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(updated);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @GetMapping(value = "/byName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getByName(@PathVariable("name")String name){
        return super.getByName(name);
    }


    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<Restaurant> getBetweenDates(
            @RequestParam(value = "from", required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return super.getBetweenDates(startDate, endDate);
    }
}
