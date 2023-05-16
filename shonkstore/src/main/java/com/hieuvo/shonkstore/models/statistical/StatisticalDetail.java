package com.hieuvo.shonkstore.models.statistical;

import com.hieuvo.shonkstore.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statistical_details")
public class StatisticalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id", columnDefinition = "varchar(255)", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int soldQuantity;

    @Column(columnDefinition = "decimal(9,2)", nullable = false)
    private double revenue;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "statistical_id", columnDefinition = "varchar(255)", nullable = false)
    private Statistical statistical;
}
