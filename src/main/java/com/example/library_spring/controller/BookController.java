package com.example.library_spring.controller;
import com.example.library_spring.model.Book;

import com.example.library_spring.service.BooksService;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class BookController {
    private final BooksService booksService;

    @GetMapping("/textOfYourBook/{bookId}")
    public String getTextOfBook(@PathVariable Long bookId){

        return booksService.getTextOfBook(bookId);
    }
    @PostMapping("/updateBookText/{bookId}/{bookText}")
    public void updateBookText(@PathVariable Long bookId, @PathVariable String bookText){

        booksService.updateBookText(bookId,bookText);
    }
    @PostMapping("/createBook")
    public void createBook(@RequestBody  Book book){
        booksService.createBook(book);
    }

}
