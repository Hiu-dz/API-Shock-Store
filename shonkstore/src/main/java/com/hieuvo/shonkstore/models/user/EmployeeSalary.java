package com.hieuvo.shonkstore.models.user;

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
@Table(name = "employee_salaries")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "decimal(9,0)")
    private Double salary;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isPaid;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(columnDefinition = "user_id", nullable = false)
    private User user;
}
