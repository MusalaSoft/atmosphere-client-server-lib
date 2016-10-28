package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * The serial number of the device as a {@link DeviceParameter}.
 * 
 * @author vassil.angelov
 *
 */
public class SerialNumber extends SingleValueDeviceParameter<String> {
    private static final long serialVersionUID = 8852106326279523342L;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    SerialNumber(String serialNumber) {
        value = serialNumber;
    }

}
