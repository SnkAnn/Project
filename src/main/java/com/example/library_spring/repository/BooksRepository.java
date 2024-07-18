package com.example.library_spring.repository;

import com.example.library_spring.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long> {



    @Query("SELECT b.text FROM Book b WHERE b.id=:bookId")
    String getTextOfBook(@ Param("bookId") Long bookId);

    @Query("SELECT b FROM Book b WHERE b.author.id = :authorId")
    List<Book> getBooksByAuthor(@Param("authorId") Long authorId);

    @Query("UPDATE Book b SET b.text = :text WHERE b.id = :id")
    @Modifying
    @Transactional
    void updateBookText(@Param("id") Long bookId,@Param("text") String bookText);
}
