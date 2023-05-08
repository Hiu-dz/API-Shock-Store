package com.hieuvo.shonkstore.common.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseObject {
    private int status;
    private String message;
    private Object data;
}
