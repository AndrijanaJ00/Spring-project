package com.example.it355.controller;

import com.example.it355.entity.Book;
import com.example.it355.exception.ResourceNotFoundException;
import com.example.it355.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllFromBook(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        Book book = bookService.findById(bookId);
        return ResponseEntity.ok(book);
    }

//    @PutMapping
//    public ResponseEntity<Book> update(@RequestBody Book book){
//        return ResponseEntity.ok(bookService.update(book));
//    }

    @DeleteMapping("/{bookId}")
    public void deleteById(@PathVariable Integer bookId){
        bookService.deleteById(bookId);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody Book bookDetails){
        Book book = bookService.findById(bookId);

        book.setName(bookDetails.getName());
        book.setImage(bookDetails.getImage());
        book.setRating(bookDetails.getRating());
        book.setDescription(bookDetails.getDescription());

        Book updatedBook = bookService.save(book);
        return ResponseEntity.ok(updatedBook);
    }

}
