package com.restaurants.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Dish.GET_ALL, query = "SELECT d FROM Dish d order by d.createdOrUpdated DESC "),
        @NamedQuery(name = Dish.GET_BETWEEN, query = "SELECT d FROM Dish d WHERE d.createdOrUpdated BETWEEN :startDate AND :endDate ORDER BY d.createdOrUpdated DESC "),
        @NamedQuery(name = Dish.GET_WITH_RESTAURANT, query = "SELECT d FROM Dish d LEFT JOIN FETCH d.restaurant WHERE d.id = :id")
})



@Entity
@Table(name = "dishes")
public class Dish extends BaseEntity{

    public static final String GET_ALL = "Dish.findAll";
    public static final String GET_BETWEEN = "Dish.getBetweenDates";
    public static final String GET_WITH_RESTAURANT = "Dish.getWithRestaurant";

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 1, max = 5000)
    private Double price;

    @Column(name = "created", columnDefinition = "DATE")
    @NotNull
    private LocalDate createdOrUpdated = LocalDate.now();

    @JoinColumn(name = "restaurant_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Restaurant restaurant;

    public Dish(){

    }

    public Dish(String name, Double price){
        this(null, name, price, null);

    }

    public Dish(String name, Double price, Restaurant restaurant ){
        this(null, name, price, restaurant);

    }

    public Dish(Integer id, String name, Double price, Restaurant restaurant) {
        super(id);
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getCreatedOrUpdated() {
        return createdOrUpdated;
    }

    @Override
    public String toString() {
        return name + "  " + price + " $";
    }
}
