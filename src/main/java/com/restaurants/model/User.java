package com.restaurants.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
        @NamedQuery(name = User.VOTE_RESTAURANT, query = "UPDATE User u set u.restaurantId = ?1, u.voteDate = ?3 WHERE u.id = ?2")
})

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    public static final String BY_EMAIL = "User.getByEmail";
    public static final String VOTE_RESTAURANT = "User.voteRestaurant";

        @NotEmpty
        @Column(name = "name", nullable = false)
        private String name;

        @Email
        @NotBlank
        @Column(name = "email", nullable = false, unique = true)
        private String email;

        @NotBlank
        @Size(min = 4)
        @Column(name = "password")
        private String password;

        @Enumerated(EnumType.STRING)
        @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name ="user_id"))
        @Column(name = "role")
        @ElementCollection(fetch = FetchType.EAGER)
        private Set<Role> roles;


        @Column(name = "voted_restaurant")
        private Integer restaurantId;

        @Column(name = "voted")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate voteDate;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRoles());
    }

    public User(String name, String email, String password, Role role, Role... roles) {
        this(null, name, email, password, EnumSet.of( role, roles));
    }

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, password, EnumSet.of( role, roles));
    }

    public User(Integer id, String name, String email, String password, Collection<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.voteDate = null;
        this.restaurantId = null;
        setRoles(roles);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
