package com.example.it355.service.impl;

import com.example.it355.entity.Author;
import com.example.it355.repository.AuthorRepository;
import com.example.it355.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Integer authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new NoSuchElementException("Ne postoji autor sa tim id-em."));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Integer authorId) {
        authorRepository.deleteById(authorId);
    }
}
