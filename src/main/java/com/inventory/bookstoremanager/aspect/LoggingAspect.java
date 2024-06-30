package com.inventory.bookstoremanager.aspect;

import com.inventory.bookstoremanager.dto.BookDTO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /** Instance of Logger to implement Logging.*/
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /** Aspect Implementation for update() method of BookService class logging.*/
    @Before("execution(* com.inventory.bookstoremanager.service.BookService.findById(Long)) && args(id)")
    public void logBeforeFindById(Long id) {
        logger.info("Finding book by id: {}", id);
    }
    @AfterReturning(pointcut = "execution(* com.inventory.bookstoremanager" +
            ".service.BookService.findById(Long))", returning = "result")
    public void logAfterReturningFindById(Object result) {
        logger.info("Book found: {}", ((BookDTO) result).getTitle());
    }


    /** Aspect Implementation for update() method of BookService class logging.*/
    @Pointcut("execution(* com.inventory.bookstoremanager.service.BookService" +
            ".update(Long, com.inventory.bookstoremanager.dto.BookDTO))")
    public void updateMethod() {}

    @Before("updateMethod()")
    public void logBeforeUpdate() {
        logger.info("Starting update operation...");
    }

    @Before("updateMethod() && args(id, bookDTO)")
    public void logBeforeUpdateDetails(Long id, BookDTO bookDTO) {
        logger.info("Updating book with id: {}", id);
        logger.debug("Updating book with id: {}", bookDTO);
    }

    @AfterReturning(pointcut = "updateMethod()", returning = "result")
    public void logAfterReturningUpdate(Object result) {
        logger.info("Book updated successfully: {}", ((BookDTO) result).getTitle());
    }

    /** Aspect Implementation for delete() method of BookService class logging.*/
    @Before("execution(* com.inventory.bookstoremanager.service.BookService.delete(Long)) && args(id)")
    public void logBeforeDelete(Long id) {
        logger.info("Deleting book with id: {}", id);
    }
    @AfterReturning("execution(* com.inventory.bookstoremanager.service.BookService.delete(Long))")
    public void logAfterDelete() {
        logger.info("Book deleted successfully");
    }

    /** Aspect Implementation for delete() method of BookService class logging.*/
    @Before("execution(* com.ineventory.bookstoremanager.service.BookService.addNewBook(..) && args(bookDTO))")
    public void logBeforeAddNewBook(BookDTO bookDTO) {
        logger.info("Adding book with id {}", bookDTO.getTitle());
    }
    @AfterReturning(value = "execution(* com.ineventory.bookstoremanager.service.BookService.addNewBook(..))", returning = "result")
    public void logAfterReturningAddNewBook(Object result) {
        logger.info("Added book successfully with {}", ((BookDTO) result).getTitle());
    }

}
