package com.hieuvo.shonkstore.models.product.key;

import com.hieuvo.shonkstore.models.user.User;
import com.hieuvo.shonkstore.models.product.Category;
import com.hieuvo.shonkstore.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products_categories")
public class ProductCategory {
    @EmbeddedId
    private ProductCategoryKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", columnDefinition = "varchar(255)", nullable = false)
    private Product product;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", columnDefinition = "varchar(255)", nullable = false)
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", columnDefinition = "varchar(255)", nullable = false)
    private User user;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;
}
