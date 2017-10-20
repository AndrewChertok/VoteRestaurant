package com.restaurants.web.vote;

import com.restaurants.AuthorizedUser;
import com.restaurants.model.Restaurant;
import com.restaurants.service.VoteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(VoteController.URL)
public class VoteController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    static final String URL = "/vote";

    @Autowired
    VoteServiceImpl voteService;

    @GetMapping("/{id}")
    public ResponseEntity<String> vote(@PathVariable("id") int id){
        int userId = AuthorizedUser.id();
        log.info("vote {}", id, userId);
       boolean isVoted = voteService.vote(id, userId);

       if(isVoted){
           return new ResponseEntity<String>(HttpStatus.OK);
       }else{
           return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
       }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Restaurant, Integer> getResults(){
        return voteService.resultsOfPoll();
    }
}
