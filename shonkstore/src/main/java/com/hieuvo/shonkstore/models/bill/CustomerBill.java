package com.hieuvo.shonkstore.models.bill;

import com.hieuvo.shonkstore.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_bills")
public class CustomerBill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", columnDefinition = "varchar(255)", nullable = false)
    private User user;

    @Column(name = "invoice_time", columnDefinition = "datetime", nullable = false)
    private LocalDateTime invoiceTime;

    @Column(name = "is_paid", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isPaid;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "customerBill")
    private List<CustomerBillDetail> customerBillDetails;
}
