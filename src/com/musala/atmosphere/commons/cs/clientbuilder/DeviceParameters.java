package com.musala.atmosphere.commons.cs.clientbuilder;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.util.Pair;

/**
 * Holds the parameters, needed to construct new device. If the current parameter is not needed it is set by default to
 * "No preference".
 * 
 * @author vladimir.vladimirov
 * 
 */

public class DeviceParameters implements Serializable {
    private static final long serialVersionUID = -2882881882742875572L;

    private static Logger LOGGER = Logger.getLogger(DeviceParameters.class.getCanonicalName());

    /**
     * Default values for device properties.
     */
    public static final DeviceType DEVICE_TYPE_NO_PREFERENCE = DeviceType.NO_PREFERENCE;

    public static final DeviceOs DEVICE_OS_NO_PREFERENCE = DeviceOs.NO_PREFERENCE;

    public static final int API_LEVEL_NO_PREFERENCE = DEVICE_OS_NO_PREFERENCE.getApiLevel();

    public static final int RESOLUTION_HEIGHT_NO_PREFERENCE = -1;

    public static final int RESOLUTION_WIDTH_NO_PREFERENCE = -1;

    public static final int DPI_NO_PREFERENCE = -1;

    public static final int RAM_NO_PREFERENCE = -1;

    public static final String SERIALNUMBER_NO_PREFERENCE = "not set";

    public static final String MODEL_NO_PREFERENCE = "not set";

    public static final Boolean HAS_CAMERA_NO_PREFERENCE = null;

    /**
     * DeviceParameters data members.
     */
    private DeviceType deviceType;

    private DeviceOs deviceOs;

    private int apiLevel;

    private int resolutionHeight;

    private int resolutionWidth;

    private int dpi;

    private int ram;

    private String serialNumber;

    private String model;

    private Boolean hasCamera;

    /**
     * Constructor that sets all properties to their default (no preference) values.
     */
    public DeviceParameters() {
        deviceType = DEVICE_TYPE_NO_PREFERENCE;
        deviceOs = DEVICE_OS_NO_PREFERENCE;
        resolutionHeight = RESOLUTION_HEIGHT_NO_PREFERENCE;
        resolutionWidth = RESOLUTION_WIDTH_NO_PREFERENCE;
        dpi = DPI_NO_PREFERENCE;
        ram = RAM_NO_PREFERENCE;
        apiLevel = API_LEVEL_NO_PREFERENCE;
        serialNumber = SERIALNUMBER_NO_PREFERENCE;
        model = MODEL_NO_PREFERENCE;
        hasCamera = HAS_CAMERA_NO_PREFERENCE;
    }

    /**
     * Constructor that sets all properties to that of the device information given
     * 
     * @param os
     *        - {@link DeviceInformation DeviceInformation}
     */
    public DeviceParameters(DeviceInformation deviceInformation) {
        this();
        if (deviceInformation.isEmulator()) {
            deviceType = DeviceType.EMULATOR_ONLY;
        } else {
            deviceType = DeviceType.DEVICE_ONLY;
        }
        String os = deviceInformation.getOS();
        deviceOs = DeviceOs.getDeviceOs(os);
        apiLevel = deviceInformation.getApiLevel();
        Pair<Integer, Integer> resolution = deviceInformation.getResolution();
        resolutionHeight = resolution.getKey();
        resolutionWidth = resolution.getValue();
        dpi = deviceInformation.getDpi();
        ram = deviceInformation.getRam();
        serialNumber = deviceInformation.getSerialNumber();
        model = deviceInformation.getModel();
        hasCamera = deviceInformation.hasCamera();
    }

    /**
     * Returns the set wanted device type.
     * 
     * @return - {@link DeviceType DeviceType}
     */
    public DeviceType getDeviceType() {
        return deviceType;
    }

    /**
     * Sets the wanted device type - emulator, real device or no preference.
     * 
     * @param deviceType
     *        - {@link DeviceType DeviceType}
     */
    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Returns the set wanted OS on the testing device.
     * 
     * @return - {@link DeviceOs DeviceOs}
     */
    public DeviceOs getOs() {
        return deviceOs;
    }

    /**
     * Sets the wanted OS of the testing device.
     * 
     * @param os
     *        - {@link DeviceOs DeviceOs}
     */
    public void setOs(DeviceOs os) {
        if (apiLevel == API_LEVEL_NO_PREFERENCE) {
            this.deviceOs = os;
            return;
        }

        int osApiLevel = deviceOs.getApiLevel();
        if (osApiLevel != apiLevel) {
            this.deviceOs = os;
            apiLevel = osApiLevel;
            String messageFormat = "Device OS and API level missmatch when trying to set the OS type. Device API level changed to %d.";
            String message = String.format(messageFormat, osApiLevel);
            LOGGER.warn(message);
        }
    }

    /**
     * Returns the set wanted device serial number.
     * 
     * @return
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the wanted device serial number.
     * 
     * @param serialNumber
     *        - the wanted serial number.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Returns the set wanted device model.
     * 
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the wanted device model.
     * 
     * @param model
     *        - the wanted model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Returns the set wanted <i>height</i> of the testing device screen resolution.
     * 
     * @return the screen resolution height.
     */
    public int getResolutionHeight() {
        return resolutionHeight;
    }

    /**
     * Sets the wanted screen resolution height.
     * 
     * @param resolutionHeight
     *        the wanted screen resolution height.
     */
    public void setResolutionHeight(int resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }

    /**
     * Returns the set wanted <i>width</i> of the testing device screen resolution.
     * 
     * @return the resolution width
     */
    public int getResolutionWidth() {
        return resolutionWidth;
    }

    /**
     * Sets the wanted screen resolution width.
     * 
     * @param resolutionWidth
     *        - the wanted screen resolution width.
     */
    public void setResolutionWidth(int resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    /**
     * Returns the set wanted <i>dpi</i> of the testing device's screen.
     * 
     * @return the screen dpi.
     */
    public int getDpi() {
        return dpi;
    }

    /**
     * Sets the wanted screen dpi of the testing device.
     * 
     * @param dpi
     *        the wanted screen dpi.
     */
    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    /**
     * Returns the set wanted <i>RAM</i> of the testing device.
     * 
     * @return the set wanted ram.
     */
    public int getRam() {
        return ram;
    }

    /**
     * Sets the wanted RAM amount of the testing device.
     * 
     * @param ram
     *        the wanted device ram amount.
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(int apiLevel) {
        if (deviceOs == DeviceOs.NO_PREFERENCE) {
            this.apiLevel = apiLevel;
            return;
        }

        int currentApiLevel = deviceOs.getApiLevel();
        if (currentApiLevel != apiLevel) {
            this.apiLevel = apiLevel;
            deviceOs = DEVICE_OS_NO_PREFERENCE;
            String messageFormat = "Device OS and API level missmatch when trying to set the API level. Device OS changed to %s.";
            String message = String.format(messageFormat, DEVICE_OS_NO_PREFERENCE.toString());
            LOGGER.warn(message);
        }
    }

    /**
     * Returns expected value for camera presence on the device.
     * 
     * @return - true, if there is a requirement for hardware presence of camera on the device, and false otherwise.
     */
    public Boolean hasCameraPresent() {
        return hasCamera;
    }

    /**
     * Sets whether a camera should be presented on the required device.
     * 
     * @param hasCamera
     *        - true, if the allocated device for this properties, should have at least one camera, and false if it must
     *        not have any.
     */
    public void setCameraPresent(Boolean hasCamera) {
        this.hasCamera = hasCamera;
    }
}
