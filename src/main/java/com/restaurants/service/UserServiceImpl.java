package com.restaurants.service;

import com.restaurants.model.User;
import com.restaurants.repository.UserRepository;
import com.restaurants.repository.datajpa.DataJpaUserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("jpaUserRepository")
    private UserRepository repository;

    public void setRepository(DataJpaUserRepositoryImpl repository) {
        this.repository = repository;
    }



    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {

        repository.delete(id);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void setDateVote(LocalDate dateVote, Integer id) {
        repository.setDateVote(dateVote, id);
    }
}
