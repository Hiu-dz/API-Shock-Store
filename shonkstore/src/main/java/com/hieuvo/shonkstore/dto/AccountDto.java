package com.hieuvo.shonkstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private UUID id;
    private String username;
    private String password;
    @JsonProperty(value = "isActivated")
    private boolean isActivated;
    @JsonProperty(value = "isDeleted")
    private boolean isDeleted;
}
