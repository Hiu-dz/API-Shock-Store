package com.hieuvo.shonkstore.models;

import com.hieuvo.shonkstore.models.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "varchar(255)", nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(name = "is_activated", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isActivated;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1)", nullable = false)
    private boolean isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", columnDefinition = "varchar(255)", nullable = false)
    private Employee employee;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.employee.getType().getValue()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
