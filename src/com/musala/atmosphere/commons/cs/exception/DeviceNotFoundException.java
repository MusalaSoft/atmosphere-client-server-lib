package com.musala.atmosphere.commons.cs.exception;

/**
 * This exception is thrown when an action fails, because the server fails to find the target device.
 * 
 * @author yavor.stankov
 * 
 */
public class DeviceNotFoundException extends Exception {
    private static final long serialVersionUID = 339776069590257729L;

    /**
     * Creates new {@link DeviceNotFoundException} with the given message.
     * 
     * @param message
     *        - message representing the error that occurred
     */
    public DeviceNotFoundException(String message) {
        super(message);
    }

    /**
     * Creates new {@link DeviceNotFoundException} with the given message and {@link Throwable throwable}.
     * 
     * @param message
     *        - message representing the error that occurred
     * @param throwable
     *        - the cause for the exception
     */
    public DeviceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
