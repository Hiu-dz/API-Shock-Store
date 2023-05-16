package com.hieuvo.shonkstore.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserType {
    OWNER("Owner"),
    MANAGER("Manager"),
    CASHIER("Cashier"),
    CUSTOMER("Customer");

    private String value;

    public static UserType getType(String employeeType) {
        for (UserType type : UserType.values()) {
            if (type.getValue().equals(employeeType)) {
                return type;
            }
        }
        return null;
    }
}
