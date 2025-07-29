package com.example.goodreads.repository;

import com.example.goodreads.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<CollectionEntity, Integer> {
}
