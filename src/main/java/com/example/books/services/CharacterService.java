package com.example.books.services;

import com.example.books.controllers.templates.CharacterRequest;
import com.example.books.models.Book;
import com.example.books.models.Character;
import com.example.books.repositories.BookRepository;
import com.example.books.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private BookRepository bookRepository;

    public Character addCharacter(CharacterRequest characterRequest) {
        Character newCharacter = new Character();
        newCharacter.setName(characterRequest.name);
        Book ofBook = bookRepository.getOne(characterRequest.book_id);
        newCharacter.setBook(ofBook);
        return characterRepository.saveAndFlush(newCharacter);
    }

}
