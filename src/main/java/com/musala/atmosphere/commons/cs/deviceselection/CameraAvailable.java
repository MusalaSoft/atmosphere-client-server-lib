package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * {@link DeviceParameter} for an available camera on the device.
 * 
 * @author vassil.angelov
 *
 */
public class CameraAvailable extends SingleValueDeviceParameter<Boolean> {

    private static final long serialVersionUID = -5242810190811301186L;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    CameraAvailable(boolean isAvailable) {
        value = isAvailable;
    }

}
