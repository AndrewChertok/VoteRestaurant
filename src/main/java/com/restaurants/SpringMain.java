package com.restaurants;


import com.restaurants.model.Dish;
import com.restaurants.model.Restaurant;
import com.restaurants.model.Role;
import com.restaurants.model.User;
import com.restaurants.web.restaurant.RestaurantRestController;
import com.restaurants.web.user.AdminRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SpringMain {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "userName", "email", "password", Role.ROLE_ADMIN));
            RestaurantRestController restaurantRestController = appCtx.getBean(RestaurantRestController.class);

            List<Dish> dishes = new ArrayList<>();
          //  dishes.add(new Dish("Fish", Double.valueOf(55)));
          //  dishes.add(new Dish("Roastbeaf", Double.valueOf(99)));
            Restaurant restaurant = new Restaurant("Jococo", dishes);
            restaurantRestController.save(restaurant);

            System.out.println(restaurantRestController.getAll());



        }
    }

}
