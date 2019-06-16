package com.travix.medusa.busyflights.exception;

public class BusyFlightException extends Throwable {

    private final String errorCode;

    public BusyFlightException( String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
