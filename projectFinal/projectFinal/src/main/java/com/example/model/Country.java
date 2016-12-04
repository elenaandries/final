package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ebastic on 11/23/2016.
 */
//@Entity
//@Table(name="country")
public class Country implements Serializable {

    private Integer id;
    private String name;

    //@Id @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country(){

    }

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
