package com.jaydev.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaydev.ecommerce.Entity.CategoryEntity;
import com.jaydev.ecommerce.repository.CategoryRepository;

import jakarta.persistence.OptimisticLockException;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

  public CategoryEntity createCategory(CategoryEntity category) {
        if (categoryRepository.findByName(category.getName()) != null) {
            throw new RuntimeException("Category with name '" + category.getName() + "' already exists");
        }
        try {
            return categoryRepository.save(category);
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Error creating category: The entity was updated or deleted by another transaction", e);
        } catch (Exception e) {
            throw new RuntimeException("Error creating category: " + e.getMessage(), e);
        }
    }

    public List<CategoryEntity> createCategories(List<CategoryEntity> categories) {
        return categoryRepository.saveAll(categories);
    }

    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public CategoryEntity updateCategory(Long id, CategoryEntity category) {
        CategoryEntity existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
