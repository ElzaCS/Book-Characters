package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="stclare")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stclare {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long st_id;
    private String st_name;
    private String st_description;
    public Stclare() {
    }
    public Long getSt_id() {
        return st_id;
    }
    public void setSt_id(Long st_id) {
        this.st_id = st_id;
    }
    public String getSt_name() {
        return st_name;
    }
    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }
    public String getSt_description() {
        return st_description;
    }
    public void setSt_description(String st_description) {
        this.st_description = st_description;
    }
}

