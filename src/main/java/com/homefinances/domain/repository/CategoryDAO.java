package com.homefinances.domain.repository;


import com.homefinances.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category, Integer> {
    Category findCategoryByDescription(String description);
}
