package com.example.books.services;

import com.example.books.controllers.templates.CharacterRequest;
import com.example.books.controllers.templates.GenreRequest;
import com.example.books.models.Book;
import com.example.books.models.Character;
import com.example.books.models.Genre;
import com.example.books.repositories.BookRepository;
import com.example.books.repositories.CharacterRepository;
import com.example.books.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookRepository bookRepository;

    public Genre addGenre(GenreRequest genreRequest) {
        System.out.println("genreRequest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(genreRequest);
        Genre newGenre = new Genre();
        newGenre.setName(genreRequest.name);
        List<Book> ofBook = bookRepository.findAllById(genreRequest.book_id);
        System.out.println("ofBook!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(ofBook);
        newGenre.setBook(ofBook);
        System.out.println("newGenre!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(newGenre);
        return genreRepository.saveAndFlush(newGenre);
    }

}
