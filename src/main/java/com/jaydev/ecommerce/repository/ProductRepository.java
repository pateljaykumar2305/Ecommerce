package com.jaydev.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaydev.ecommerce.Entity.ProductEntity;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
        
      // Find products containing a certain string in their name (case-insensitive)
      List<ProductEntity> findByNameContainingIgnoreCase(String name);
  
      // Find products by price greater than a given value
      List<ProductEntity> findByPriceGreaterThan(Double price); // Corrected: No space
  
      // Find products by price less than or equal to a given value
      List<ProductEntity> findByPriceLessThanEqual(Double price); // Corrected: No space
  
      // Find products ordered by price in descending order
      List<ProductEntity> findAllByOrderByPriceDesc();

}
