package com.example.library_spring.repository;

import com.example.library_spring.model.Author;
import com.example.library_spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.name = :name AND a.biography = :biography")
    Author get(@Param("name") String name, @Param("biography") String biography);


    @Query("UPDATE Author a SET a.biography = :description WHERE a.id = :id")
    @Modifying
    @Transactional
    void updateAuthorDescription(@Param("id") Long authorId, @Param("description") String description);



}
