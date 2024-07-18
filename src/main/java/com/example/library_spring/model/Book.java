package com.example.library_spring.model;

 
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_seq")
    @SequenceGenerator(name = "books_seq", sequenceName = "BOOKS_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(name = "description")
    private String description;



    @Column(name = "amount_of_reads")
    private Integer amountOfReads;

    @Column(name = "adding_time")
    private ZonedDateTime addingTime;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "text")
    private String text;


}