package com.inventory.bookstoremanager.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private String nationality;
    private Date birthDate;
    private Set<BookDTO> books;

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String firstName, String lastName,
                     String biography, String nationality,
                     Date birthDate, Set<BookDTO> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Set<BookDTO> getBooks() {return books;}
    public void setBooks(Set<BookDTO> books) {this.books = books;}

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", biography='" + biography + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", books=" + books +
                '}';
    }
}