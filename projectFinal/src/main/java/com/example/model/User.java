package com.example.model;

import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ebastic on 11/23/2016.
 */
@Entity
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @Column(name="password", nullable = false)
    private String password;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name="user_cities",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="city_id")
    )
    private Collection<City> listOfCities;

    protected User(){
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<City> getListOfCities() {
        return listOfCities;
    }

    public void setListOfCities(Collection<City> listOfCities) {
        this.listOfCities = listOfCities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
