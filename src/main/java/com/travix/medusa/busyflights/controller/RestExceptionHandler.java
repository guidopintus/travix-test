package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.exception.BusyFlightException;
import com.travix.medusa.busyflights.exception.ErrorDTO;
import com.travix.medusa.busyflights.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private Environment env;

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorDTO> handleInvalidInputException(InvalidInputException ex) {
        return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<ErrorDTO> buildResponse(BusyFlightException ex, HttpStatus status) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getErrorCode());
        return new ResponseEntity<>(errorDTO, status);
    }

}
