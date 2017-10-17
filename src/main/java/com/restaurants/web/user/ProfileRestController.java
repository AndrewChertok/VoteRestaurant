package com.restaurants.web.user;

import com.restaurants.AuthorizedUser;
import com.restaurants.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ProfileRestController.URL)
public class ProfileRestController extends AbstractUserController{

    static final String URL = "/user/profile";

    @DeleteMapping(value = "/delete")
    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        return super.get(AuthorizedUser.id());
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        super.update(user, AuthorizedUser.id());
    }



}
