package com.restaurants.service;


import com.restaurants.model.Restaurant;
import com.restaurants.model.User;
import com.restaurants.repository.RestaurantRepository;
import com.restaurants.repository.UserRepository;
import com.restaurants.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class VoteServiceImpl implements VoteService {

    private static final LocalTime EXPIRED_TIME = LocalTime.parse("23:00");

    private static int count = 0;

    @Autowired
    @Qualifier("jpaRestaurantRepository")
    private RestaurantRepository restaurantRepository;

    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Autowired
    @Qualifier("jpaUserRepository")
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean vote(int id, int userId) {
        User votingUser = userRepository.get(userId);
        LocalDate lastVote = votingUser.getVoteDate() == null ? null : votingUser.getVoteDate();
        Restaurant restaurant = restaurantRepository.get(id);
        Restaurant restHaveVoted = votingUser.getRestaurantId() == null ? null : restaurantRepository.get(votingUser.getRestaurantId()) ;



        if(DateTimeUtil.isSameDay(lastVote , LocalDate.now())){
            if(DateTimeUtil.isTillExpiredTime(EXPIRED_TIME)){
                if(restHaveVoted == null){
                    return voteFirstTime(votingUser, restaurant, restaurant.getVotes());
                } else if(!restaurant.getName().equalsIgnoreCase(restHaveVoted.getName())){
                    return voteOtherTimes(votingUser, restaurant, restHaveVoted);
                } else return false;

            }else return false;

        } else {
            if(DateTimeUtil.isTillExpiredTime(EXPIRED_TIME)){
               return voteOtherTimes(votingUser, restaurant, restHaveVoted);
            } else return false;
        }
    }


    private boolean voteOtherTimes(User votingUser, Restaurant restaurant, Restaurant restHaveVoted){
        Integer votesNewRest = restaurant.getVotes();
            Integer votesOldRest = restHaveVoted.getVotes();
            voteFirstTime(votingUser, restaurant, votesNewRest);
            restaurantRepository.setVotes(--votesOldRest, restHaveVoted.getId());
            return true;
    }


    private boolean voteFirstTime(User votingUser, Restaurant restaurant, Integer votesNewRest){
        userRepository.setRestaurantVoted(restaurant.getId(),votingUser.getId());
        restaurantRepository.setVotes(++votesNewRest, restaurant.getId());
        return true;
    }

}
