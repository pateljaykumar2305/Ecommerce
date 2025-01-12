package com.jaydev.ecommerce.Entity;

import jakarta.persistence.*; // Corrected import

@Entity
@Table(name = "products")
public class ProductEntity {

   
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @Column(name = "sku", nullable = false, unique = true)
    private String sku;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category; // Corrected type

    // Constructors (Important!)
    public ProductEntity() {} // JPA requires a no-arg constructor

    public ProductEntity(String name, String description, Double price, String sku, CategoryEntity category) { // Corrected constructor
        this.name = name;
        this.description = description;
        this.price = price;
        this.sku = sku;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public CategoryEntity getCategory() { // Corrected getter
        return category;
    }

    public void setCategory(CategoryEntity category) { // Corrected setter
        this.category = category;
    }
}
