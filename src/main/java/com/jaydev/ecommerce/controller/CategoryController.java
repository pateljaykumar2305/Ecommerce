package com.jaydev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jaydev.ecommerce.Entity.CategoryEntity;
import com.jaydev.ecommerce.Service.CategoryService;

/**
 * REST controller for managing categories.
 * 
 * This controller provides endpoints to create, retrieve, and manage categories.
 * 
 * Endpoints:
 * 
 * - POST /api/categories: Create a new category.
 * - POST /api/categories/batch: Create multiple categories in batch.
 * - GET /api/categories: Retrieve all categories.
 * - GET /api/categories/{id}: Retrieve a category by its ID.
 * - GET /api/categories/test: Test endpoint to check if the controller is working.
 * 
 * Exception Handling:
 * 
 * - Handles RuntimeException and returns a BAD_REQUEST status with the exception message.
 * 
 * Dependencies:
 * 
 * - CategoryService: Service layer for category operations.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

     @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    @PostMapping("/batch")
    public List<CategoryEntity> createCategories(@RequestBody List<CategoryEntity> categories) {
        return categoryService.createCategories(categories);
    }

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "CategoryController is working!";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }
}
