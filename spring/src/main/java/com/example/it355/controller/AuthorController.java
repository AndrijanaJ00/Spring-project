package com.example.it355.controller;

import com.example.it355.entity.Author;
import com.example.it355.entity.Book;
import com.example.it355.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllFromAuthor(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getBookById(@PathVariable Integer authorId) {
        Author author = authorService.findById(authorId);
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author){
        return ResponseEntity.ok(authorService.save(author));
    }

//    @PutMapping
//    public ResponseEntity<Author> update(@RequestBody Author author){
//        return ResponseEntity.ok(authorService.update(author));
//    }

    @DeleteMapping("/{authorId}")
    public void deleteById(@PathVariable Integer authorId){
        authorService.deleteById(authorId);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer authorId, @RequestBody Author authorDetails){
        Author author = authorService.findById(authorId);

        author.setFirstName(authorDetails.getFirstName());
        author.setLastName(authorDetails.getLastName());

        Author updatedAuthor = authorService.save(author);
        return ResponseEntity.ok(updatedAuthor);
    }
}
