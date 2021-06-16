package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
//@Builder
@Entity(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long book_id;

    private String name;
//    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Character> characters;

    @ManyToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Genre> genre;

//    @ManyToMany(cascade = { CascadeType.ALL })

    public Book() {
    }
}
