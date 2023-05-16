package com.hieuvo.shonkstore.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShonkSExceptionMessage {
    public static final String SHONKS_001 = "Required information cannot be empty";
    public static final String SHONKS_002 = "Something went wrong";

//    Account
    public static final String ACCOUNT_001 = "Confirm password and password don't match";
    public static final String ACCOUNT_002 = "Account already exists by username: ";
    public static final String ACCOUNT_003 = "Username doesn't exist";
    public static final String ACCOUNT_004 = "Username or password is incorrect";

//    Employee
    public static final String EMPLOYEE_001 = "This employee already exists by surname, name and type ";

//    Employee salary
    public static final String SALARY_001 = "Employee of this salary could not be found by id: ";
}
