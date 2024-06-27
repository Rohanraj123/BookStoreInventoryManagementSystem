package com.inventory.bookstoremanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private String publisher;
    private Date publicationYear;
    private String genre;
    private String language;
    private int numberOfPages;
    private String description;
    private String coverImageUrl;
    private String availabilityStatus;
    private String shelfLocation;
    private double rating;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;
}
