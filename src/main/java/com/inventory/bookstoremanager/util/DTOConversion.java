package com.inventory.bookstoremanager.util;

import com.inventory.bookstoremanager.dto.BookDTO;
import com.inventory.bookstoremanager.dto.ReviewDTO;
import com.inventory.bookstoremanager.entity.Book;
import com.inventory.bookstoremanager.entity.Review;
import org.springframework.beans.BeanUtils;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class that contains method to converts Book Entity to Book DTOs
 * @author Rohanjha123
 */
public class DTOConversion {
    /**
     * Method to convert Book entity to BookDTO
     * @param book Book entity
     * @return BookDTO converted dto of book entity
     */
    public static BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO, "author", "reviews");
        if (book.getAuthor() != null) {
            bookDTO.setAuthorId(book.getAuthor().getId());
        }
        if (book.getReviews() != null && !book.getReviews().isEmpty()) {
            Set<ReviewDTO> reviewDTOs = book.getReviews().stream()
                    .map(DTOConversion::convertToDTO)
                    .collect(Collectors.toSet());
            bookDTO.setReviews(reviewDTOs);
        }
        return bookDTO;
    }

    /**
     * Supporting method to convert Review entity to ReviewDTO
     * @param review Review entity
     * @return ReviewDTO converted dto of Review entity
     */
    public static ReviewDTO convertToDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(review, reviewDTO, "book");
        return reviewDTO;
    }
}
