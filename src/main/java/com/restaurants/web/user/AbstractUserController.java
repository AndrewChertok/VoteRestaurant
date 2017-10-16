package com.restaurants.web.user;

import com.restaurants.AuthorizedUser;
import com.restaurants.model.User;
import com.restaurants.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("userService")
    private UserService service;


    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        return service.save(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user) {
        int id = AuthorizedUser.id();
        log.info("update {} with id={}", user, id);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }


    public void setDateVote(LocalDate dateVote) {
        int id = AuthorizedUser.id();
        service.setDateVote(dateVote, id);
    }
}
