package com.musala.atmosphere.commons.cs.clientbuilder;

/**
 * This enumeration contains all possible values for devices' OS. For now there are six options.
 * 
 * @author yavor.stankov
 * 
 */

public enum DeviceOs {
    /**
     * <i><b>Android 4.1</b></i>
     */
    JELLY_BEAN_4_1("4.1"),

    /**
     * <i><b>Android 4.2.1</b></i>
     */
    JELLY_BEAN_MR1_4_2_1("4.2.1"),

    /**
     * <i><b>Android 4.2.2</b></i>
     */
    JELLY_BEAN_MR1_4_2_2("4.2.2"),

    /**
     * <i><b>Android 4.3</b></i>
     */
    JELLY_BEAN_MR2_4_3("4.3"),

    /**
     * <i><b>Android 4.4</b></i>
     */
    KITKAT_4_4("4.4"),

    /**
     * It means <i>"any available OS"</i>. OS by default when constructing new device.
     */
    NO_PREFERENCE("no_preference");

    private String value;

    private DeviceOs(String deviceOs) {
        this.value = deviceOs;
    }

    @Override
    public String toString() {
        return value;
    }

    public DeviceOs getDeviceOs(String os) {
        switch (os) {
            case "4.1":
                return JELLY_BEAN_4_1;
            case "4.2.1":
                return JELLY_BEAN_MR1_4_2_1;
            case "4.2.2":
                return JELLY_BEAN_MR1_4_2_2;
            case "4.3":
                return JELLY_BEAN_MR2_4_3;
            case "4.4":
                return KITKAT_4_4;
            default:
                return NO_PREFERENCE;
        }
    }

}
