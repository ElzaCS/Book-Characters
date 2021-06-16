package com.example.books.controllers;

import com.example.books.controllers.templates.CharacterRequest;
import com.example.books.controllers.templates.GenreRequest;
import com.example.books.models.Character;
import com.example.books.models.Famous5;
import com.example.books.models.Genre;
import com.example.books.repositories.CharacterRepository;
import com.example.books.repositories.GenreRepository;
import com.example.books.services.CharacterService;
import com.example.books.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> list() {
        return genreRepository.findAll();
    }

//    @GetMapping
//    @RequestMapping("{id}")
//    public Famous5 get(@PathVariable Long id) {
//        return famous5Repository.getOne(id);
//    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Genre create(@RequestBody final GenreRequest famous5){
        return genreService.addGenre(famous5);
    }

//    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id){
//        //wont delete children records
//        bookRepository.deleteById(id);
//    }
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public Book update(@PathVariable Long id,@RequestBody Famous5 famous5){
//        Book existingFamous5=bookRepository.getOne(id);
//        BeanUtils.copyProperties(famous5, existingFamous5, "id");
//        return bookRepository.saveAndFlush(existingFamous5);
//    }
}
