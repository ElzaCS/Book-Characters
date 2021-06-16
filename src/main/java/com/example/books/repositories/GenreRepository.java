package com.example.books.repositories;

import com.example.books.models.Character;
import com.example.books.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
