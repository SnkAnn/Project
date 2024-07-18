package com.example.library_spring.service.Impl;

import com.example.library_spring.model.Book;
import com.example.library_spring.model.Author;

import com.example.library_spring.repository.AuthorRepository;
import com.example.library_spring.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId).get();
    }



    @Override
    public void updateAuthorDescription(Long authorId, String newDescription) {
        authorRepository.updateAuthorDescription(authorId,newDescription);
    }


}
