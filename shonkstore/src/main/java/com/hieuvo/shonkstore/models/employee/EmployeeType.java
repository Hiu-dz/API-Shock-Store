package com.hieuvo.shonkstore.models.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EmployeeType {
    OWNER("Owner"),
    MANAGER("Manager"),
    CASHIER("Cashier");

    private String value;
}
