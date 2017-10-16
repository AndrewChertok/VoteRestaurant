package com.restaurants.web.user;

import com.restaurants.AuthorizedUser;
import com.restaurants.model.User;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AdminRestController extends AbstractUserController{


    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User get(int id) {
        return super.get(AuthorizedUser.id());
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void delete(int id) {
        super.delete(AuthorizedUser.id());
    }

    @Override
    public void update(User user) {
        super.update(user);
    }

    @Override
    public User getByMail(String email) {
        return super.getByMail(email);
    }


    public void setDateVote(LocalDate dateVote) {
        super.setDateVote(dateVote);
    }
}
