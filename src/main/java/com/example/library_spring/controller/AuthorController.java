package com.example.library_spring.controller;

import com.example.library_spring.model.Author;

import com.example.library_spring.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("createAuthor")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        authorService.createAuthor(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @GetMapping("getAuthor/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Long authorId) {
        Author author = authorService.getAuthor(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("deleteAuthor/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("updateAuthorDescription/{id}")
    public ResponseEntity<Void> updateAuthorDescription(
            @PathVariable("id") Long authorId,
            @RequestParam("newDescription") String newDescription) {
        authorService.updateAuthorDescription(authorId, newDescription);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
