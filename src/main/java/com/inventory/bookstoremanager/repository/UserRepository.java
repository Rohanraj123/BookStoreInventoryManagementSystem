package com.inventory.bookstoremanager.repository;

import com.inventory.bookstoremanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserName(String userName);
    Boolean existsByUserName(String userName);
}
