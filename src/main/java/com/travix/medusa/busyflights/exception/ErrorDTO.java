package com.travix.medusa.busyflights.exception;

public class ErrorDTO {


    private final String code;

    public ErrorDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}