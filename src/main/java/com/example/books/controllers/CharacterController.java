package com.example.books.controllers;

import com.example.books.controllers.templates.CharacterRequest;
import com.example.books.models.Book;
import com.example.books.models.Character;
import com.example.books.repositories.BookRepository;
import com.example.books.repositories.CharacterRepository;
import com.example.books.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/char")
public class CharacterController {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> list() {
        return characterRepository.findAll();
    }

//    @GetMapping
//    @RequestMapping("{id}")
//    public Famous5 get(@PathVariable Long id) {
//        return famous5Repository.getOne(id);
//    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Character create(@RequestBody final CharacterRequest characterRequest){
        return characterService.addCharacter(characterRequest);
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
