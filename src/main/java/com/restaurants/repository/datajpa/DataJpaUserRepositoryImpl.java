package com.restaurants.repository.datajpa;

import com.restaurants.model.User;
import com.restaurants.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private CrudUserRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
       userRepository.deleteById(id);
    }

    @Override
    public User get(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public void setRestaurantVoted(Integer restId, Integer userId){
        userRepository.setRestaurantVoted(restId, userId, LocalDate.now());
    }

    @Override
    public void setDateVote(LocalDate dateVote, Integer id) {
        userRepository.setDateVote(dateVote, id);
    }
}
