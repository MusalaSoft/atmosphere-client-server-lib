package com.musala.atmosphere.commons.cs.exception;

/**
 * Thrown when a passed passkey is not valid in the {@link DeviceProxy DeviceProxy} context.
 * 
 * @author georgi.gaydarov
 * 
 */
public class InvalidPasskeyException extends Exception {
    /**
     * auto-generated serialization id
     */
    private static final long serialVersionUID = -8520385658531894843L;

    public InvalidPasskeyException() {
    }

    // Constructor that accepts a message
    public InvalidPasskeyException(String message) {
        super(message);
    }

    public InvalidPasskeyException(String message, Throwable inner) {
        super(message, inner);
    }
}
