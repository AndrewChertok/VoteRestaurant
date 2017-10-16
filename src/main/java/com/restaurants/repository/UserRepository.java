package com.restaurants.repository;

import com.restaurants.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository {

    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

  default void setRestaurantVoted(Integer restId, Integer userId){

  }


  default void setDateVote(LocalDate dateVote, Integer id){

  }

}
