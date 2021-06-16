package com.example.books.repositories;

import com.example.books.models.Character;
import com.example.books.models.Famous5;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
