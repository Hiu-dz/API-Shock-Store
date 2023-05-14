package com.hieuvo.shonkstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hieuvo.shonkstore.common.constants.ShonkSConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class EmployeeDto {
    private UUID id;
    private String surname;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ShonkSConstant.DATE_FORMAT)
    private LocalDate dateOfBirth;
    private int age;
    private String email;
    private String address;
    private String phone;
    private String type;
    private Double salary;
    @JsonProperty(value = "isWorked")
    private boolean isWorked;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ShonkSConstant.DATE_TIME_FORMAT)
    private LocalDateTime beginTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ShonkSConstant.DATE_TIME_FORMAT)
    private LocalDateTime endTime;

}
