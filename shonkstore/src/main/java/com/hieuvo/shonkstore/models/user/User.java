package com.hieuvo.shonkstore.models.user;

import com.hieuvo.shonkstore.models.Account;
import com.hieuvo.shonkstore.models.bill.CustomerBill;
import com.hieuvo.shonkstore.models.product.key.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String surname;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(name = "date_of_birth", columnDefinition = "date")
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private int age;

    @Column(columnDefinition = "varchar(255)")
    private String email;

    @Column(columnDefinition = "nvarchar(255)")
    private String address;

    @Column(columnDefinition = "varchar(11)")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private UserType type;

    @Column(name = "begin_time", columnDefinition = "datetime(0)")
    private LocalDateTime beginTime;

    @Column(name = "end_time", columnDefinition = "datetime(0)")
    private LocalDateTime endTime;

    @OneToOne(mappedBy = "user")
    private EmployeeSalary employeeSalary;

    @OneToMany(mappedBy = "user")
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "user")
    private List<CustomerBill> customerBills;

    @OneToOne(mappedBy = "user")
    private Account account;
}
