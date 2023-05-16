package com.hieuvo.shonkstore.models.statistical;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statistics")
public class Statistical {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "date", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int totalSoldQuantity;

    @Column(columnDefinition = "decimal(9,2)", nullable = false)
    private double totalRevenue;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "statistical")
    private List<StatisticalDetail> statisticalDetails;
}
