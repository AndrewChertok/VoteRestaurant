package com.restaurants.repository.InMemoryRepository;

import com.restaurants.model.Dish;
import com.restaurants.model.Restaurant;
import com.restaurants.repository.RestaurantRepository;
import com.restaurants.service.RestaurantService;
import com.restaurants.util.DateTimeUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class RestaurantInMemoryRepository implements RestaurantRepository {

    private AtomicInteger id = new AtomicInteger(0);

  private ConcurrentHashMap<Integer, Restaurant> restaurants = new ConcurrentHashMap<>();
/*
  private List<Restaurant> rest = new ArrayList<>();
    {
        rest.add(new Restaurant("Mario",new Dish("Fish", Double.valueOf(55)), new Dish("Meat", Double.valueOf(66))));
        rest.add(new Restaurant("Veronica", new Dish("Roastbeaf", Double.valueOf(99))));
        rest.add(new Restaurant("House of taste", new Dish("Juice", Double.valueOf(5))));
        rest.add(new Restaurant("Belaggio", new Dish("Pizza", Double.valueOf(77))));
        rest.add(new Restaurant("Rome", new Dish("Salad", Double.valueOf(33))));

        rest.forEach(restaurant -> save(restaurant));
    }
    */



    @Override
    public Restaurant save(Restaurant restaurant) {

        if(restaurant.isNew()){
            restaurant.setId(id.incrementAndGet());
           return restaurants.put(restaurant.getId(), restaurant);
        }else{
            Restaurant oldRestaurant = get(restaurant.getId());
            restaurant.setVotes(oldRestaurant.getVotes());
            return restaurants.put(oldRestaurant.getId(), restaurant);
        }

    }


    @Override
    public void delete(int id) {
         restaurants.remove(id, get(id));
    }

    @Override
    public Restaurant get(int id) {
        return restaurants.get(id);
    }

    @Override
    public List<Restaurant> getBetweenDates(LocalDate start, LocalDate end) {
        return restaurants.values().stream().filter(restaurant -> DateTimeUtil.isBetweenDate(restaurant.getCreatedOrUpdated(), start, end)).collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurants.values().stream().collect(Collectors.toList());
    }


}
