package com.musala.atmosphere.commons.cs.deviceselection;

import java.io.Serializable;

/**
 * Interface representing a parameter by which a device can be described. All known parameters are described in the
 * {@link Visitor} interface.
 * 
 * @author vassil.angelov
 *
 */
public interface DeviceParameter extends Serializable {

    /**
     * Visitor that defines API for differentiating the various known implementations of {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public interface Visitor {
        void visit(ApiLevel.Minimum minApiLevel);

        void visit(ApiLevel.Maximum minApiLevel);

        void visit(ApiLevel.Target minApiLevel);

        void visit(DeviceOs deviceOs);

        void visit(DeviceType deviceType);

        void visit(SerialNumber serialNumber);

        void visit(DeviceModel deviceModel);

        void visit(ScreenParameter.Width screenWidth);

        void visit(ScreenParameter.Height screenHeight);

        void visit(ScreenParameter.DPI screenDpi);

        void visit(CameraAvailable cameraAvailable);

        void visit(RamCapacity ramCapacity);
    }

    void accept(Visitor visitor);

}
