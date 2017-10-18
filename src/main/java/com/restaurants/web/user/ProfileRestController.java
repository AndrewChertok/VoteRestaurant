package com.restaurants.web.user;

import com.restaurants.AuthorizedUser;
import com.restaurants.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ProfileRestController.URL)
public class ProfileRestController extends AbstractUserController{

    static final String URL = "/user/profile";

    @DeleteMapping
    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        return super.get(AuthorizedUser.id());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        user.setId(AuthorizedUser.id());
        super.update(user);
    }



}
