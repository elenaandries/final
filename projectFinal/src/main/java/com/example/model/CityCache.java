package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ebastic on 12/4/2016.
 */
@Entity
@Table(name="city_cache")
public class CityCache {

    @Id
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="json", nullable = false)
    private String json;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getJson() {
        return json;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "CityCache{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", json='" + json + '\'' +
                '}';
    }
}
