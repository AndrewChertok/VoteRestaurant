package com.restaurants.repository;

import com.restaurants.model.User;
import java.util.List;

public interface UserRepository {

    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

   void setRestaurantVoted(Integer restId, Integer userId);

}
