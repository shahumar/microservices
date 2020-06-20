package com.sumer.labs.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumer.labs.productservice.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
