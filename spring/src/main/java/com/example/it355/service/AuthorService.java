package com.example.it355.service;

import com.example.it355.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Integer authorId);

    Author save(Author author);

    Author update(Author author);

    void deleteById(Integer authorId);
}
