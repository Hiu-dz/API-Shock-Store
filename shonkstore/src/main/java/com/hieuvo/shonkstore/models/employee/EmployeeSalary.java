package com.hieuvo.shonkstore.models.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_salaries")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "decimal(9,0)")
    private Double salary;

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private boolean isPaid;

//    Join tables
    @OneToOne(mappedBy = "employeeSalary")
    private Employee employee;
}