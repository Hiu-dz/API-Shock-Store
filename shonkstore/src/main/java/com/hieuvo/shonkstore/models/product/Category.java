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
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isActivated;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productsCategories;
}
