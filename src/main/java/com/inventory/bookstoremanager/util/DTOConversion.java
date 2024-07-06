package com.inventory.bookstoremanager.util;

import com.inventory.bookstoremanager.dto.BookDTO;
import com.inventory.bookstoremanager.entity.Book;
import org.springframework.beans.BeanUtils;

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
        return bookDTO;
    }
}
