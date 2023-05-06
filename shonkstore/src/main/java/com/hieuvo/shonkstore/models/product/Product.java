package com.hieuvo.shonkstore.models.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(columnDefinition = "nvarchar(255)")
    private String description;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private double price;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isSold;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

//    Join tables
    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productsCategories;
}
