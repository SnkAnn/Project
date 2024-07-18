package com.example.library_spring.service.Impl;

import com.example.library_spring.model.Book;
import com.example.library_spring.repository.BooksRepository;
import com.example.library_spring.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    @Override
    public String getTextOfBook(Long bookId) {
        Book book = booksRepository.findById(bookId).orElse(null);
        return (book != null) ? book.getText() : null;
    }

    @Override
    public void updateBookText(Long bookId, String bookText) {
        booksRepository.updateBookText(bookId, bookText);
    }

    @Override
    public Book createBook(Book book) {
        booksRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getBooksByAuthor(Long authorId) {
        return booksRepository.getBooksByAuthor(authorId);
    }
    @Override
    public boolean deleteBook(Long bookId) {
        if (booksRepository.existsById(bookId)) {
            booksRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    @Override
    public Book getBookById(Long bookId) {
        return booksRepository.findById(bookId).orElse(null);
    }
}
