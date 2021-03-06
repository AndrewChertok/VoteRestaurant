package com.restaurants.web.user;

import com.restaurants.model.User;
import com.restaurants.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public abstract class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    public List<User> getAll() {
        log.info("getAll");
        return userService.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return userService.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        return userService.save(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        userService.delete(id);
    }

    public void update(User user) {
        log.info("update {} ", user);
        userService.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return userService.getByEmail(email);
    }
}
