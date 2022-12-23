package com.banque.misr.irrigation.system.exception;

public class SensorNotAvailableException extends RuntimeException {

    public SensorNotAvailableException(String errorMessage) {
        super(errorMessage);
    }

}
