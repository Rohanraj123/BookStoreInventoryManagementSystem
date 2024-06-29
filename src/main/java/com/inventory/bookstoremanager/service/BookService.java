package com.inventory.bookstoremanager.service;

import com.inventory.bookstoremanager.dto.BookDTO;
import com.inventory.bookstoremanager.dto.ReviewDTO;
import com.inventory.bookstoremanager.entity.Author;
import com.inventory.bookstoremanager.entity.Book;
import com.inventory.bookstoremanager.entity.Review;
import com.inventory.bookstoremanager.repository.AuthorRepository;
import com.inventory.bookstoremanager.repository.BookRepository;
import com.inventory.bookstoremanager.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.inventory.bookstoremanager.util.DTOConversion.convertToDTO;
import static com.inventory.bookstoremanager.util.EntityConversion.convertToEntity;

/**
 * @author Rohanjha123
 *
 * Service class that holds buissness logic for Book management feature
 */

@Service
public class BookService {
    /** Instance of BookRepository.*/
    private final BookRepository bookRepository;
    /** Instance of AuthorRepository.*/
    private final AuthorRepository authorRepository;
    /** Instance of ReviewRepository.*/
    private final ReviewRepository reviewRepository;


    /**
     * Constructor of BookService Class to access it
     * using repositories.
     *
     * @param bookRepository instance of BookRepository interface
     * @param authorRepository instance of AuthorRepository interface
     */
    @Autowired
    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    /**
     * Method to find book by id
     * Uses internal method of CrudRepository
     *
     * @param id I'd to find book by id
     * @return converted book dto object
     */
    public BookDTO findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Book not found with id: " + id));
        return convertToDTO(book);
    }

    /**
     * Method to update book in database
     * Uses internal method of CrudRepository
     *
     * @param id I'd of the book
     * @param bookDTO object of BookDTO
     * @return DTO of updated book
     */
    @Transactional
    public BookDTO update(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Book not found with id : " + id));

        BeanUtils.copyProperties(bookDTO, existingBook, "id");

        if (bookDTO.getAuthorDTO() != null) {
            Long authorId = bookDTO.getAuthorDTO().getId();
            Author author;
            if (authorId != null) {
                author = authorRepository.findById(authorId)
                        .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));
            } else {
                author = convertToEntity(bookDTO.getAuthorDTO());
                author = authorRepository.save(author);
            }
            existingBook.setAuthor(author);
        }
        Book savedBook = bookRepository.save(existingBook);
        return convertToDTO(savedBook);
    }

    /**
     * Method to delete a book by id
     * Uses internal method of CrudRepository
     *
     * @param id I'd of book
     */
    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Method to add new book into database
     * Uses internal method of CrudRepository
     *
     * @param bookDTO BookDTO object to save book
     * @return converted book dto object to
     */
    @Transactional
    public BookDTO addNewBook(BookDTO bookDTO) {
       Book newBook = convertToEntity(bookDTO);

       /* Add Author to the book.*/
       Author author = convertToEntity(bookDTO.getAuthorDTO());
       if (author.getId() != null) {
           authorRepository.findById(author.getId())
                   .orElseThrow(() ->
                           new IllegalArgumentException("Author not found with id : "
                                   + author.getId()));
       } else {
           authorRepository.save(author);
       }
       newBook.setAuthor(author);

       Book savedBook = bookRepository.save(newBook);

       /* Add Reviews to the book.*/
       Set<Review> saveReviews = new HashSet<>();
       Set<ReviewDTO> reviewDTOs = bookDTO.getReviews();
       if (reviewDTOs != null && !reviewDTOs.isEmpty()) {
           for (ReviewDTO reviewDTO : reviewDTOs) {
               Review review = convertToEntity(reviewDTO);
               review.setBook(savedBook);
               Review savedReview = reviewRepository.save(review);
               saveReviews.add(savedReview);
           }
       }
       newBook.setReviews(saveReviews);

       return convertToDTO(savedBook);
    }
}
