package com.restaurants.web.user;

import com.restaurants.AuthorizedUser;
import com.restaurants.model.User;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileRestController extends AbstractUserController{

    public void delete() {
        super.delete(AuthorizedUser.id());
    }
    
    public User get() {
        return super.get(AuthorizedUser.id());
    }
    
    public void update(User user) {
        super.update(user);
    }



}
