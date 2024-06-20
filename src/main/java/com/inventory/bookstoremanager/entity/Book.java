package com.inventory.bookstoremanager.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private LocalDate publicationDate;
    private int stockLevel;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
