package com.musala.atmosphere.commons.cs.clientbuilder;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceOs;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceType;
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
    public static final DeviceType DEVICE_TYPE_NO_PREFERENCE = null;

    public static final DeviceOs DEVICE_OS_NO_PREFERENCE = null;

    public static final int TARGET_API_LEVEL_NO_PREFERENCE = -1;

    public static final int RESOLUTION_HEIGHT_NO_PREFERENCE = -1;

    public static final int RESOLUTION_WIDTH_NO_PREFERENCE = -1;

    public static final int DPI_NO_PREFERENCE = -1;

    public static final int RAM_NO_PREFERENCE = -1;

    public static final String SERIALNUMBER_NO_PREFERENCE = "not set";

    public static final String MODEL_NO_PREFERENCE = "not set";

    public static final Boolean HAS_CAMERA_NO_PREFERENCE = null;

    public static final int MIN_API_LEVEL_NO_PREFERENCE = -1;

    public static final int MAX_API_LEVEL_NO_PREFERENCE = -1;

    /**
     * DeviceParameters data members.
     */
    private DeviceType deviceType;

    private DeviceOs deviceOs;

    private int targetApiLevel;

    private int resolutionHeight;

    private int resolutionWidth;

    private int dpi;

    private int ram;

    private String serialNumber;

    private String model;

    private Boolean hasCamera;

    private int minApiLevel;

    private int maxApiLevel;

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
        targetApiLevel = TARGET_API_LEVEL_NO_PREFERENCE;
        serialNumber = SERIALNUMBER_NO_PREFERENCE;
        model = MODEL_NO_PREFERENCE;
        hasCamera = HAS_CAMERA_NO_PREFERENCE;
        minApiLevel = MIN_API_LEVEL_NO_PREFERENCE;
        maxApiLevel = MAX_API_LEVEL_NO_PREFERENCE;

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
        targetApiLevel = deviceInformation.getApiLevel();
        Pair<Integer, Integer> resolution = deviceInformation.getResolution();
        resolutionHeight = resolution.getKey();
        resolutionWidth = resolution.getValue();
        dpi = deviceInformation.getDpi();
        ram = deviceInformation.getRam();
        serialNumber = deviceInformation.getSerialNumber();
        model = deviceInformation.getModel();
        hasCamera = deviceInformation.hasCamera();
        maxApiLevel = MAX_API_LEVEL_NO_PREFERENCE;
        minApiLevel = MIN_API_LEVEL_NO_PREFERENCE;
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
        if (targetApiLevel == TARGET_API_LEVEL_NO_PREFERENCE) {
            this.deviceOs = os;
            return;
        }

        int osApiLevel = os.getApiLevel();
        if (osApiLevel != targetApiLevel) {
            this.deviceOs = os;
            targetApiLevel = osApiLevel;
            String messageFormat = "Device OS and target API level missmatch when trying to set the OS type. Device target API level changed to %d.";
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

    /**
     * Gets target API level for selecting a device.
     */
    public int getTargetApiLevel() {
        return targetApiLevel;
    }

    /**
     * Sets the target API Version for selecting a device.
     * 
     * @param apiLevel
     *        - target API level to be set
     */
    public void setTargetApiLevel(int apiLevel) {
        if ((apiLevel < minApiLevel || apiLevel > maxApiLevel) && (maxApiLevel != MAX_API_LEVEL_NO_PREFERENCE)) {
            String invalidApiLevelMessage = "The given target API level is not in the set range. Target ApiVersion was not changed.";
            LOGGER.warn(invalidApiLevelMessage);
            return;
        }

        if (deviceOs == null) {
            this.targetApiLevel = apiLevel;
            return;
        }

        int currentApiLevel = deviceOs.getApiLevel();
        if (currentApiLevel != apiLevel) {
            this.targetApiLevel = apiLevel;
            deviceOs = DEVICE_OS_NO_PREFERENCE;
            String messageFormat = "Device OS and target API level missmatch when trying to set the API level. Device OS changed to %s.";
            String message = String.format(messageFormat, DEVICE_OS_NO_PREFERENCE.toString());
            LOGGER.warn(message);
        }
    }

    /**
     * Sets the minimum API version the device should have in order to be selected.
     * 
     * @param minApiLevel
     *        - API level to be set
     */
    public void setMinApiLevel(int minApiLevel) {
        if (targetApiLevel != TARGET_API_LEVEL_NO_PREFERENCE && minApiLevel > targetApiLevel) {
            String invalidApiVersionMessage = "The given minimum API version is greater than the set target API version. Minimum API version was not changed!";
            LOGGER.warn(invalidApiVersionMessage);
            return;
        }

        if (maxApiLevel != MAX_API_LEVEL_NO_PREFERENCE && minApiLevel > maxApiLevel) {
            String invalidMinApiVersionMessage = "The given minimum API version is greater than the set maximum API version. Minimum API version was not changed!";
            LOGGER.warn(invalidMinApiVersionMessage);
            return;
        }

        this.minApiLevel = minApiLevel;
    }

    /**
     * Sets the maximum API version the device should have in order to be selected.
     * 
     * @param maxApiLevel
     *        - API level to be set
     */
    public void setMaxApiLevel(int maxApiLevel) {
        if (targetApiLevel != TARGET_API_LEVEL_NO_PREFERENCE && maxApiLevel < targetApiLevel) {
            String invalidApiVersionMessage = "The given maximum API version is lesser than the set target API version. Maximum API version was not changed!";
            LOGGER.warn(invalidApiVersionMessage);
            return;
        }

        if (maxApiLevel < minApiLevel) {
            String invalidMaxApiVersionMessage = "The given maximum API version is lesser than the set minimum API version. Maximum API version was not changed!";
            LOGGER.warn(invalidMaxApiVersionMessage);
            return;
        }

        this.maxApiLevel = maxApiLevel;
    }

    /**
     * Gets the minimum API version the device should have in order to be selected.
     * 
     * @return minimum API version
     */
    public int getMinApiLevel() {
        return minApiLevel;
    }

    /**
     * Gets maximum API version the device should have in order to be selected.
     * 
     * @return maximum API version
     */
    public int getMaxApiLevel() {
        return maxApiLevel;
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

    @Override
    public String toString() {
        String deviceParameters = String.format("DeviceParameters [deviceType=%s, deviceOs=%s, targetApiLevel=%s, resolutionHeight=%s, resolutionWidth=%s, dpi=%s, ram=%s, serialNumber=%s, model=%s, hasCamera=%s, minApiLevel=%s, maxApiLevel=%s]",
                                                deviceType,
                                                deviceOs,
                                                targetApiLevel,
                                                resolutionHeight,
                                                resolutionWidth,
                                                dpi,
                                                ram,
                                                serialNumber,
                                                model,
                                                hasCamera,
                                                minApiLevel,
                                                maxApiLevel);
        return deviceParameters;
    }
}
