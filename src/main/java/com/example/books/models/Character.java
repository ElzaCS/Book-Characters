package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
//@Builder
@Entity(name="book_char")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Character {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long char_id;

    private String name;

    //Foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonIgnore //wont call Book object again in loop
    private Book book;

    public Character() {
    }

//    public Long getChar_id() {
//        return char_id;
//    }
//
//    public void setChar_id(Long char_id) {
//        this.char_id = char_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
}
