package com.inventory.bookstoremanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BookDTO {
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
    private Long authorId;
    private AuthorDTO authorDTO;
}
