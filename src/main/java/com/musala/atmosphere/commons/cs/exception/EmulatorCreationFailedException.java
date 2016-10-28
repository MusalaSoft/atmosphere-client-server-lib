package com.musala.atmosphere.commons.cs.exception;

import com.musala.atmosphere.commons.exceptions.AtmosphereRuntimeException;

/**
 * Thrown when creation of an emulator device fails.
 * 
 * @author yordan.petrov
 * 
 */
public class EmulatorCreationFailedException extends AtmosphereRuntimeException {
    // TODO: it's good to have a root RE exception in our app. Maybe it is good to introduce this intermediate level so
    // people can guard against multiple of our REs in the same time
    private static final long serialVersionUID = -2665753514724505625L;

    public EmulatorCreationFailedException() {
        super();
    }

    public EmulatorCreationFailedException(String message) {
        super(message);
    }

    public EmulatorCreationFailedException(String message, Throwable inner) {
        super(message, inner);
    }

}
