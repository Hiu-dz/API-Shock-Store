package com.hieuvo.shonkstore.exceptions;

import com.hieuvo.shonkstore.common.responses.ResponseError;
import com.hieuvo.shonkstore.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ResponseError responseError = new ResponseError(
                LocalDateTime.now(), httpStatus, exception.getMessage()
        );

        return new ResponseEntity<>(responseError, httpStatus);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ResponseError responseError = new ResponseError(
                LocalDateTime.now(), httpStatus, exception.getMessage()
        );

        return new ResponseEntity<>(responseError, httpStatus);
    }
}
