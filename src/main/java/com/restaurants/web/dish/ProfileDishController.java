package com.restaurants.web.dish;


import com.restaurants.model.Dish;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(ProfileDishController.URL)
public class ProfileDishController extends AbstractDishController{
    
    static final String URL = "/dish";
    

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish getById(@PathVariable("id")Integer id){
        return super.getById(id);
    }

    @GetMapping(value = "/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
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
