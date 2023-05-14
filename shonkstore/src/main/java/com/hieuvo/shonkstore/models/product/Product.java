package com.hieuvo.shonkstore.models.product;

import com.hieuvo.shonkstore.models.bill.BillDetail;
import com.hieuvo.shonkstore.models.product.key.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @JdbcTypeCode(SqlTypes.VARCHAR)
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

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productsCategories;

    @OneToMany(mappedBy = "product")
    private List<BillDetail> billDetails;
}
