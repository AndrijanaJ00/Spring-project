package com.example.it355.service.impl;

import com.example.it355.entity.Book;
import com.example.it355.repository.BookRepository;
import com.example.it355.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException("Ne postoji knjiga sa tim id-em."));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
