package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by ebastic on 11/23/2016.
 */
@Entity
@Table(name="cities")
public class City implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    public Long id;

    @Column(name="name", unique = true, nullable = false)
    public String name;

    /*@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="countryId")
    private Country country;*/

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="user_cities",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="city_id")
    )
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }*/
}
