package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * The serial number of the device as a {@link DeviceParameter}.
 * 
 * @author vassil.angelov
 *
 */
public class SerialNumber extends SingleValueDeviceParameter<String> {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    SerialNumber(String serialNumber) {
        value = serialNumber;
    }

}
