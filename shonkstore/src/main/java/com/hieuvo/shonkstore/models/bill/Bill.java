package com.hieuvo.shonkstore.models.bill;

import com.hieuvo.shonkstore.models.employee.Employee;
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
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "employee_id", columnDefinition = "varchar(255)", nullable = false)
    private Employee employee;

    @Column(name = "invoice_time", columnDefinition = "datetime", nullable = false)
    private LocalDateTime invoiceTime;

    @Column(name = "is_paid", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isPaid;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "bill")
    private List<BillDetail> billDetails;
}
