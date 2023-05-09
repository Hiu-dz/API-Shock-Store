package com.hieuvo.shonkstore.common.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hieuvo.shonkstore.common.constants.ShonkSConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ShonkSConstant.DATE_TIME_FORMAT)
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
}
