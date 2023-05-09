package com.hieuvo.shonkstore.models.bill;

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
@Table(name = "bill_details")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id", columnDefinition = "varchar(255)", nullable = false)
    private Product product;

    @Column(name = "ordered_quantity", nullable = false)
    private int orderedQuantity;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bill_id", columnDefinition = "varchar(255)", nullable = false)
    private Bill bill;
}
