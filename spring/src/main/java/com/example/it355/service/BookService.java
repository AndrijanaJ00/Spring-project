package com.example.it355.service;

import com.example.it355.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer bookId);

    Book save(Book book);

    Book update(Book book);

    void deleteById(Integer bookId);
}
