package com.musala.atmosphere.commons.cs.exception;

import com.musala.atmosphere.commons.cs.deviceselection.DeviceParameter;

/**
 * Exception indicating that a certain {@link DeviceParameter device parameter} was not successfully visited and
 * appended to the device selection query.
 * 
 * @author filareta.yordanova
 * 
 */
public class DeviceSelectionFailedException extends RuntimeException {
    private static final long serialVersionUID = 3393704420154975836L;

    public DeviceSelectionFailedException() {
        super();
    }

    public DeviceSelectionFailedException(String message) {
        super(message);
    }

    public DeviceSelectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceSelectionFailedException(Throwable cause) {
        super(cause);
    }

}
