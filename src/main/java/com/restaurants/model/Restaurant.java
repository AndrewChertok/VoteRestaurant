package com.restaurants.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity{

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
    private LocalDate created = LocalDate.now();

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

    public LocalDate getCreated() {
        return created;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Restaurant that = (Restaurant) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Restaurant " +
                  name + '\'' +
                ", menu=" + menu;
    }
}
