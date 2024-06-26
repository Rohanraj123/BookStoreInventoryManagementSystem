package com.inventory.bookstoremanager.repository;

import com.inventory.bookstoremanager.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
}
