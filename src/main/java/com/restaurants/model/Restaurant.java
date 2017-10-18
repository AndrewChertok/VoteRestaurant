package com.restaurants.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ALL, query ="SELECT r FROM Restaurant r order by r.createdOrUpdated DESC "),
        @NamedQuery(name = Restaurant.GET, query = "SELECT r FROM Restaurant r LEFT JOIN FETCH r.menu WHERE r.id = :id"),
        @NamedQuery(name = Restaurant.GET_BETWEEN, query = "SELECT r FROM Restaurant r WHERE r.createdOrUpdated BETWEEN :startdate AND :endDate ORDER BY r.createdOrUpdated DESC "),
        @NamedQuery(name = Restaurant.SET_VOTE, query ="UPDATE Restaurant r set r.votes = ?1 WHERE r.id = ?2"),
        @NamedQuery(name = Restaurant.GET_BY_NAME, query ="SELECT r FROM Restaurant r WHERE r.name = ?1")
})

@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity{

    public static final String GET = "Restaurant.getWithDishes";
    public static final String GET_BETWEEN = "Restaurant.getBetweenDates";
    public static final String GET_BY_NAME = "Restaurant.getByName";
    public static final String GET_ALL = "Restaurant.findAll";
    public static final String SET_VOTE = "Restaurant.setVotes";

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @CollectionTable(name = "dishes", joinColumns = @JoinColumn(name = "restaurant_id"))
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    @JsonManagedReference
    private List<Dish> menu;

    @Column(name = "votes")
    private Integer votes;

    @Column(name = "created", columnDefinition = "DATE")
    @NotNull
    private LocalDate createdOrUpdated = LocalDate.now();

    public Restaurant(){

    }

    public Restaurant(String name){
        this(null, name);

    }

    public Restaurant(String name, Dish... dish){
        this(name, Arrays.asList(dish));
    }

    public Restaurant(String name, List<Dish> menu) {
        this(null, name, menu);
    }

    public Restaurant(Integer id, String name, List<Dish> menu) {
       this(id, name);
       this.menu = menu;
    }

    public Restaurant(Integer id, String name){
        super(id);
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public LocalDate getCreatedOrUpdated() {
        return createdOrUpdated;
    }


    @Override
    public String toString() {
        return "Restaurant " +
                  name + '\'' +
                ", menu=" + menu;
    }
}
