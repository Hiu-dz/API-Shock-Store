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

    public static EmployeeType getType(String employeeType) {
        for (EmployeeType type : EmployeeType.values()) {
            if (type.getValue().equals(employeeType)) {
                return type;
            }
        }
        return null;
    }
}
