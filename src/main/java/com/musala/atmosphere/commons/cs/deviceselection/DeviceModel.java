package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * The model of a device represented as a {@link DeviceParameter}.
 *
 * @author vassil.angelov
 *
 */
public class DeviceModel extends SingleValueDeviceParameter<String> {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    DeviceModel(String model) {
        value = model;
    }

}
