package com.musala.atmosphere.commons.cs.exception;

import com.musala.atmosphere.commons.exceptions.AtmosphereRuntimeException;

/**
 * Thrown when the device is not present in the device list on the Server (the selector doesn't match any existent
 * device).
 *
 * @author dimcho.nedev
 *
 */
public class NoDeviceMatchingTheGivenSelectorException extends AtmosphereRuntimeException {
    private static final long serialVersionUID = -1238261395582738584L;

    public NoDeviceMatchingTheGivenSelectorException() {
        super();
    }

    public NoDeviceMatchingTheGivenSelectorException(String message) {
        super(message);
    }

    public NoDeviceMatchingTheGivenSelectorException(Throwable inner) {
        super(inner);
    }

    public NoDeviceMatchingTheGivenSelectorException(String message, Throwable inner) {
        super(message, inner);
    }
}
