package com.example.goodreads.repository;

import com.example.goodreads.entity.PatronEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<PatronEntity, Integer> {
}
