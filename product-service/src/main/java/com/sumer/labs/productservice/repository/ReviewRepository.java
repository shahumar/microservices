package com.sumer.labs.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumer.labs.productservice.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
