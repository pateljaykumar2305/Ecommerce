package com.jaydev.ecommerce.Entity;

import jakarta.persistence.*;


@Table(name = "categories") // Optional: Specify table name if different from class name
@Entity
public class CategoryEntity {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Or other appropriate strategy
    private Long id;

    @Column(name = "name", nullable = false, unique = true) // Example constraints
    private String name;

    @Column(name = "description")
    private String description;

    @Version
    private Integer version;

    // Constructors (at least a no-args constructor is required by JPA)
    public CategoryEntity() {}

    public CategoryEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public CategoryEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    // toString(), equals(), and hashCode() methods for better debugging and collection handling
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
