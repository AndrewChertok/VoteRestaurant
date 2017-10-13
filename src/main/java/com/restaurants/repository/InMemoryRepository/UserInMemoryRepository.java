package com.restaurants.repository.InMemoryRepository;

import com.restaurants.model.Role;
import com.restaurants.model.User;
import com.restaurants.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Repository
public class UserInMemoryRepository implements UserRepository{

    private AtomicInteger id = new AtomicInteger(0);

    private ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    private List<User> userList = new ArrayList<>();

    {
        userList.add(new User(null, "user", "user@gmail.com", "user", Collections.singletonList(Role.ROLE_USER)));
        userList.add(new User(null, "admin", "admin@gmail.com", "admin", Collections.singletonList(Role.ROLE_ADMIN)));

        userList.forEach(user -> save(user));
    }


    @Override
    public User save(User user) {
        if(user.isNew()) user.setId(id.incrementAndGet());
        return users.put(user.getId(), user);
    }

    @Override
    public void delete(int id) {
         users.remove(id);
    }

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return users.values().stream().filter(user->user.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream().collect(Collectors.toList());
    }
}
