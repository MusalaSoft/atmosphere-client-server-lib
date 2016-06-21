package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * The RAM capacity of a device represented as a {@link DeviceParameter}.
 * 
 * @author vassil.angelov
 *
 */
public class RamCapacity extends SingleValueDeviceParameter<Integer> {
    private static final long serialVersionUID = -351232342453505125L;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    RamCapacity(int capacity) {
        value = capacity;
    }

}
