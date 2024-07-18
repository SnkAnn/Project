package com.example.library_spring.service;

import com.example.library_spring.model.Book;
import com.example.library_spring.model.Author;


import java.util.List;

public interface AuthorService {

    public void createAuthor(Author author);

    Author getAuthor(Long authorId);
    void deleteAuthor(Long authorId);


    void updateAuthorDescription(Long authorId, String newDescription);
}
