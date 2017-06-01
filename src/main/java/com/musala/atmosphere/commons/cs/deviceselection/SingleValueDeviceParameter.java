package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * Abstraction over a single valued implementations of {@link DeviceParameter}.
 * 
 * @author vassil.angelov
 * 
 * @param <T>
 *        - the type of the parameter`s value
 */
public abstract class SingleValueDeviceParameter<T> implements DeviceParameter {
    T value;

    /**
     * Retrieve the value of this device parameter.
     * 
     * @return the value of this device parameter
     */
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
