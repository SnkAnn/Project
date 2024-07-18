package com.example.library_spring.controller;
import com.example.library_spring.model.Book;

import com.example.library_spring.service.BooksService;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class BookController {
    private final BooksService booksService;

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Book book = booksService.getBookById(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book createdBook = booksService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }



    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        if (booksService.deleteBook(bookId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/text/{bookId}")
    public ResponseEntity<String> getTextOfBook(@PathVariable Long bookId) {
        String text = booksService.getTextOfBook(bookId);
        if (text == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @PutMapping("/text/{bookId}")
    public ResponseEntity<Void> updateBookText(
            @PathVariable Long bookId,
            @RequestBody String bookText) {
        booksService.updateBookText(bookId, bookText);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/author/{authorId}")

    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable Long authorId) {
        List<Book> books = booksService.getBooksByAuthor(authorId);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
