package com.hieuvo.shonkstore.repositories;

import com.hieuvo.shonkstore.models.user.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, UUID> {
}
