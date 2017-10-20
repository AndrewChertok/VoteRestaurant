package com.restaurants.service;

import com.restaurants.model.Restaurant;

import java.util.Map;

public interface VoteService {

    boolean vote(int id, int userId);

    Map<Restaurant, Integer> resultsOfPoll();

}
