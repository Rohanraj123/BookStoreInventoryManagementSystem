package com.inventory.bookstoremanager.repository;

import com.inventory.bookstoremanager.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
