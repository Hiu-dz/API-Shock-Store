package com.hieuvo.shonkstore.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShonkSExceptionMessage {
    public static final String SHONKS_001 = "Required information cannot be empty";

//    Employee
    public static final String EMPLOYEE_001 = "This employee already exists by surname, name and type ";

//    Employee salary
    public static final String SALARY_001 = "Employee of this salary could not be found by id: ";
}
