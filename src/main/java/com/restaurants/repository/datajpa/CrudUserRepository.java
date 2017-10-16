package com.restaurants.repository.datajpa;

import com.restaurants.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer>{

    @Transactional
    @Override
    User save(User user);

    @Transactional
    @Override
    void deleteById(Integer id);

    @Override
    Optional<User> findById(Integer id);

    @Query("SELECT u FROM User u WHERE u.email =?1")
    User getByEmail(String email);

    @Override
    List<User> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE User u set u.restaurantId = ?1, u.voteDate = ?3 WHERE u.id = ?2")
    void setRestaurantVoted(Integer restId, Integer userId, LocalDate date);



    @Modifying
    @Transactional
    @Query("UPDATE User u set u.voteDate = ?1 WHERE u.id = ?2")
    void setDateVote(LocalDate voteDate, Integer userId);

}
