package com.musala.atmosphere.commons.cs.exception;

/**
 * Exception indicating that a certain validation has failed.
 * 
 * @author vassil.angelov
 *
 */
public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = -5836675353275276182L;

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

}
