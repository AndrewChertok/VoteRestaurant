package com.restaurants.web.vote;

import com.restaurants.AuthorizedUser;
import com.restaurants.service.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VoteRestController {

    @Autowired
    VoteServiceImpl voteService;

    public boolean vote(int id){
        int userId = AuthorizedUser.id();
       return voteService.vote(id, userId);
    }
}
