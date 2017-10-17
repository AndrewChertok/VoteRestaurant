package com.restaurants.web.dish;

import com.restaurants.model.Dish;
import com.restaurants.model.Restaurant;
import com.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(AdminDishController.URL)
public class AdminDishController extends AbstractDishController{

    static final String URL = "/dish/admin";

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping(value = "/create/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> adminSave(@RequestBody Dish dish, @PathVariable("id") Integer restaurantId){

        dish.setRestaurant(restaurantService.get(restaurantId));

        Dish created = super.save(dish);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> adminUpdate(@RequestBody Dish dish){

        Dish updated = super.update(dish);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(updated.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){
        super.delete(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish getById(@PathVariable("id") Integer id){
        return super.getById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll(){
        return super.getAll();
    }

    @GetMapping(value = "/betweendates", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getBetweenDates(
            @RequestParam(value = "from", required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return super.getBetweenDates(startDate, endDate);
    }

}
