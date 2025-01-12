package com.jaydev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaydev.ecommerce.Entity.ProductEntity;
import com.jaydev.ecommerce.Service.ProductService;

/**
 * REST controller for managing products.
 * Provides endpoints for creating, retrieving, updating, and deleting products,
 * as well as retrieving products based on various criteria.
 * 
 * Endpoints:
 * - GET /api/products: Retrieve all products.
 * - POST /api/products/category/{categoryId}: Create a new product in a specific category.
 * - POST /api/products/category/{categoryId}/batch: Create multiple products in a specific category.
 * - GET /api/products/{id}: Retrieve a product by its ID.
 * - PUT /api/products/{id}: Update a product by its ID.
 * - DELETE /api/products/{id}: Delete a product by its ID.
 * - GET /api/products/price-greater-than/{price}: Retrieve products with a price greater than the specified value.
 * - GET /api/products/price-less-than-equal/{price}: Retrieve products with a price less than or equal to the specified value.
 * - GET /api/products/name/{name}: Retrieve products by their name.
 * - GET /api/products/name-and-price: Retrieve all products ordered by price in descending order.
 * 
 * Uses {@link ProductService} to perform operations.
 * 
 * @see ProductService
 */
@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/category/{categoryId}")
    public ProductEntity createProduct(@PathVariable Long categoryId, @RequestBody ProductEntity product) {
        return productService.createProduct(categoryId, product);
    }

    @PostMapping("/products/category/{categoryId}/batch")
    public List<ProductEntity> createProducts(@PathVariable Long categoryId, @RequestBody List<ProductEntity> products) {
        return productService.createProducts(categoryId, products);
    }
    
    @GetMapping("/products/{id}")
    public ProductEntity getProductById(@PathVariable Long id) { // Added @PathVariable
        return productService.getProductById(id);
    }   
   
    @PutMapping("/products/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) { // Added @PathVariable and @RequestBody
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/price-greater-than/{price}")
    public List<ProductEntity> getProductsByPriceGreaterThan(@PathVariable Double price)
    {
        return productService.getProductsByPriceGreaterThan(price);
    }

    @GetMapping("/products/price-less-than-equal/{price}")
    public List<ProductEntity> getProductsByPriceLessThanEqual(@PathVariable Double price)
    {
        return productService.getProductsByPriceLessThanEqual(price);
    }

    @GetMapping("/products/name/{name}")
    public List<ProductEntity> getProductsByName(@PathVariable String name)
    {
        return productService.getProductsByName(name);
    }
    
    //All the Products are Decrease order of Price
    @GetMapping("/products/name-and-price")
    public List<ProductEntity> getAllByOrderByPriceDesc() {
        return productService.getAllByOrderByPriceDesc();
    }

    

}
