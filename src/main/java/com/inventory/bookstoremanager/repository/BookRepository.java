package com.inventory.bookstoremanager.repository;

import com.inventory.bookstoremanager.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
