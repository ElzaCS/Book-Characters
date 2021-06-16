package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="genre")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long genre_id;

    private String name;

    //Many-Many Foreign key with extra table
    @ManyToMany
    @JsonIgnore //wont call Book object again in loop
    @JoinTable(
            name = "genre_book",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    private List<Book> book;

    //TODO: allow adding more genre to book which already has a genre
}
