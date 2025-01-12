package com.jaydev.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaydev.ecommerce.Entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
        
    // Custom query (example: find by name)
        CategoryEntity findByName(String name);

}
