package com.restaurants.service;

import com.restaurants.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    void update(User user);

    List<User> getAll();

}
