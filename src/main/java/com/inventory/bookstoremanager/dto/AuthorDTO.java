package com.inventory.bookstoremanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private String nationality;
    private Date birthDate;
    private Set<BookDTO> books;
}