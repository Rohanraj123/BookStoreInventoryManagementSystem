package com.inventory.bookstoremanager.util;

import com.inventory.bookstoremanager.dto.AuthorDTO;
import com.inventory.bookstoremanager.dto.BookDTO;
import com.inventory.bookstoremanager.entity.Author;
import com.inventory.bookstoremanager.entity.Book;
import org.springframework.beans.BeanUtils;

public class EntityConversion {
    public static Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book, "authorId", "reviews");
        return book;
    }
    public static Author convertToEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO, author);
        return author;
    }
    public static Review convertToEntity(ReviewDTO reviewDTO) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO, review, "bookId");
        return review;
    }
}
