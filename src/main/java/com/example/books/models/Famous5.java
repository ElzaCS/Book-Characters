package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="famous5")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Famous5 {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long fam_id;
    private String fam_name;
    private String fam_description;
    public Famous5() {    }

    public Long getFam_id() {
        return fam_id;
    }
    public void setFam_id(Long fam_id) {
        this.fam_id = fam_id;
    }
    public String getFam_name() {
        return fam_name;
    }
    public void setFam_name(String fam_name) {
        this.fam_name = fam_name;
    }
    public String getFam_description() {
        return fam_description;
    }
    public void setFam_description(String fam_description) {
        this.fam_description = fam_description;
    }
}

