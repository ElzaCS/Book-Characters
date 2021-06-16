package com.example.books.controllers;

import com.example.books.models.Book;
import com.example.books.models.Famous5;
import com.example.books.repositories.BookRepository;
import com.example.books.repositories.Famous5Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> list() {
        return bookRepository.findAll();
    }

//    @GetMapping
//    @RequestMapping("{id}")
//    public Famous5 get(@PathVariable Long id) {
//        return famous5Repository.getOne(id);
//    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody final Book famous5){
        return bookRepository.saveAndFlush(famous5);
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
