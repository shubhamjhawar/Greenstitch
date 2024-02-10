package com.example.greenstitch.Exceptions;


public class ParkingServerException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public ParkingServerException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ParkingServerException() {
        super();
    }
}
