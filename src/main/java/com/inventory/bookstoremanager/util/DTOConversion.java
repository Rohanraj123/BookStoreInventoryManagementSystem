package com.inventory.bookstoremanager.util;

import com.inventory.bookstoremanager.dto.BookDTO;
import com.inventory.bookstoremanager.dto.ReviewDTO;
import com.inventory.bookstoremanager.entity.Book;
import com.inventory.bookstoremanager.entity.Review;
import com.inventory.bookstoremanager.service.BookService;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DTOConversion {
    public static BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO, "author", "reviews");
        if (book.getAuthor() != null) {
            bookDTO.setAuthorId(book.getAuthor().getId());
        }
        if (book.getReviews() != null && !book.getReviews().isEmpty()) {
            Set<ReviewDTO> reviewDTOs =  book.getReviews().stream()
                    .map(DTOConversion::convertToDTO)
                    .collect(Collectors.toSet());
            bookDTO.setReviews(reviewDTOs);
        }
        return bookDTO;
    }
    public static ReviewDTO convertToDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(review, reviewDTO, "book");
        return reviewDTO;
    }

}
