package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * Enumeration with all possible choices for requesting physical presence of device - <i>EMULATOR_ONLY</i>,
 * <i>DEVICE_ONLY</i>, <i>EMULATOR_PREFERRED</i>, <i>DEVICE_PREFERRED</i> or <i>NO_PREFERENCE</i>.
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum DeviceType implements DeviceParameter {
    /**
     * <i><b>EMULATOR_ONLY</b></i>
     */
    EMULATOR_ONLY("emulator_only"),

    /**
     * <i><b>DEVICE_ONLY</b></i>
     */
    DEVICE_ONLY("device_only"),

    /**
     * <i><b>EMULATOR_PREFERRED</b></i>
     */
    EMULATOR_PREFERRED("emulator_preferred"),

    /**
     * <i><b>DEVICE_PREFERRED</b></i>
     */
    DEVICE_PREFERRED("device_preferred");

    private String value;

    private DeviceType(String deviceType) {
        this.value = deviceType;
    }

    @Override
    public String toString() {
        return value;
    }

    public static DeviceType getDeviceType(String type) {
        switch (type) {
            case "emulator_only":
                return EMULATOR_ONLY;
            case "device_only":
                return DEVICE_ONLY;
            case "emulator_preferred":
                return EMULATOR_PREFERRED;
            case "device_preferred":
                return DEVICE_PREFERRED;
            default:
                return null;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
