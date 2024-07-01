package com.inventory.bookstoremanager.dto;

import java.util.Date;
import java.util.Set;

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
    private Set<ReviewDTO> reviews;

    public BookDTO() {
    }

    public BookDTO(Long id, String title, String isbn, String publisher, Date publicationYear,
                   String genre, String language, int numberOfPages, String description, String coverImageUrl,
                   String availabilityStatus, String shelfLocation, double rating, Long authorId,
                   AuthorDTO authorDTO, Set<ReviewDTO> reviews) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.availabilityStatus = availabilityStatus;
        this.shelfLocation = shelfLocation;
        this.rating = rating;
        this.authorId = authorId;
        this.authorDTO = authorDTO;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCoverImageUrl() {
        return coverImageUrl;
    }
    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    public String getShelfLocation() {
        return shelfLocation;
    }
    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public Set<ReviewDTO> getReviews() {return reviews;}
    public void setReviews(Set<ReviewDTO> reviews) { this.reviews = reviews; }
    public AuthorDTO getAuthorDTO() {return authorDTO;}
    public void setAuthorDTO(AuthorDTO authorDTO) {this.authorDTO = authorDTO;}

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", shelfLocation='" + shelfLocation + '\'' +
                ", rating=" + rating +
                ", authorId=" + authorId +
                ", reviews=" + reviews +
                '}';
    }
}
