package com.scaler.demoproject.repositories;

import com.scaler.demoproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);

    Category findByTitle(String title);
}
