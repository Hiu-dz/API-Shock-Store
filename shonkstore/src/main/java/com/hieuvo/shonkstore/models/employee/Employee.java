package com.hieuvo.shonkstore.models.employee;

import com.hieuvo.shonkstore.models.bill.Bill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String surname;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(columnDefinition = "nvarchar(255)")
    private String address;

    @Column(columnDefinition = "varchar(11)")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private EmployeeType type;

    @Column(name = "is_worked", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isWorked;

    @Column(name = "begin_time", nullable = false)
    private LocalDateTime beginTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_salary_id")
    private EmployeeSalary employeeSalary;

    @OneToMany(mappedBy = "employee")
    private List<Bill> bills;
}
