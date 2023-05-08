package com.hieuvo.shonkstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class EmployeeDto {
    private UUID id;
    private String surname;
    private String name;
    private String address;
    private String phone;
    private String type;
    private Double salary;
    private boolean isWorked;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

}
