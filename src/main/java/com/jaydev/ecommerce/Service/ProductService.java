package com.jaydev.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaydev.ecommerce.Entity.CategoryEntity;
import com.jaydev.ecommerce.Entity.ProductEntity;
import com.jaydev.ecommerce.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;


    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity createProduct(Long categoryId, ProductEntity product) {
        CategoryEntity category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            product.setCategory(category);
            return productRepository.save(product);
        }
        throw new RuntimeException("Category not found");

    }

    public List<ProductEntity> createProducts(Long categoryId, List<ProductEntity> products) {
        CategoryEntity category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            for (ProductEntity product : products) {
                product.setCategory(category);
            }
            return productRepository.saveAll(products);
        }
        throw new RuntimeException("Category not found");
    }

    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductEntity updateProduct(Long id, ProductEntity product) {
        ProductEntity existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
           
            CategoryEntity category = categoryService.getCategoryByName(product.getCategory().getName());
            if (category == null) {
                category = categoryService.createCategory(product.getCategory());
            }
            existingProduct.setCategory(category);

            return productRepository.save(existingProduct);
        }
        throw new RuntimeException("Product not found");
       
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductEntity> getProductsByPriceGreaterThan(Double price)
    {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<ProductEntity> getProductsByPriceLessThanEqual(Double price)
    {
        return productRepository.findByPriceLessThanEqual(price);
    }

    public List<ProductEntity> getProductsByName(String name)
    {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<ProductEntity> getAllByOrderByPriceDesc()
    {
        return productRepository.findAllByOrderByPriceDesc();
    }

}
