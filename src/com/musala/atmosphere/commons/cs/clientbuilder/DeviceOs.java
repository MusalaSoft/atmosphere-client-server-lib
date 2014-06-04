package com.musala.atmosphere.commons.cs.clientbuilder;

/**
 * This enumeration contains all possible values for devices' OS.
 * 
 * @author yavor.stankov
 * 
 */

public enum DeviceOs {
    /**
     * <i><b>Android 4.1</b></i>
     */
    JELLY_BEAN_4_1("4.1", 16),

    /**
     * <i><b>Android 4.2.1</b></i>
     */
    JELLY_BEAN_MR1_4_2_1("4.2.1", 17),

    /**
     * <i><b>Android 4.2.2</b></i>
     */
    JELLY_BEAN_MR1_4_2_2("4.2.2", 17),

    /**
     * <i><b>Android 4.3</b></i>
     */
    JELLY_BEAN_MR2_4_3("4.3", 18),

    /**
     * <i><b>Android 4.4</b></i>
     */
    KITKAT_4_4("4.4", 19),

    /**
     * <i><b>Android 4.4.1</b></i>
     */
    KITKAT_4_4_1("4.4.1", 19),

    /**
     * <i><b>Android 4.4.2</b></i>
     */
    KITKAT_4_4_2("4.4.2", 19),

    /**
     * <i><b>Android 4.4.2</b></i>
     */
    KITKAT_4_4_3("4.4.3", 19),

    /**
     * It means <i>"any available OS"</i>. OS by default when constructing new device.
     */
    NO_PREFERENCE("no_preference", -1);

    private String deviceOs;

    private int apiLevel;

    private DeviceOs(String deviceOs, int apiLevel) {
        this.deviceOs = deviceOs;
        this.apiLevel = apiLevel;
    }

    /**
     * Gets the API level for the given operating system version.
     * 
     * @return the API level for the given operating system version.
     */
    public int getApiLevel() {
        return apiLevel;
    }

    @Override
    public String toString() {
        return deviceOs;
    }

    public DeviceOs getDeviceOs(String os) {
        for (DeviceOs currentOs : DeviceOs.values()) {
            if (os.equals(currentOs.toString())) {
                return currentOs;
            }
        }

        return NO_PREFERENCE;
    }

}
