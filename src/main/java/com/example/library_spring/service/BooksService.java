package com.example.library_spring.service;

import com.example.library_spring.model.Book;


import java.util.List;

public interface BooksService {

    String getTextOfBook(Long bookId);

    void updateBookText(Long bookId, String bookText);

    void createBook( Book book);


    List< Book> getBooksByAuthor(Long userId);
     void deleteBook(Long bookId);
}
