package com.musala.atmosphere.commons.cs.deviceselection;

import java.util.HashMap;
import java.util.Map;

import com.musala.atmosphere.commons.cs.exception.ValidationException;

/**
 * Builder for a DeviceSelector from different specified parameters a device can have. All parameters are optional but
 * if provided they should be valid and consistent with each other. If a parameter is specified more than once, only the
 * last value for this parameter is used. In case of an invalid value the corresponding method will throw
 * {@link ValidationException}, but if some specified parameters are inconsistent - an exception will be thrown when
 * trying to build the DeviceSelector. If an exception occurs in some of the modifiers, the builder is left in a valid
 * state with the specified parameters until the exception is thrown. However if exception occurs when trying to build,
 * the incompatible parameters should be resolved in order to get a DeviceSelector.
 * 
 * @author vassil.angelov
 * 
 */
public class DeviceSelectorBuilder {
    private DeviceParametersValidator validator;

    private Map<Class<? extends DeviceParameter>, DeviceParameter> definedParameters;

    /**
     * Creates new builder with no specified parameters.
     */
    public DeviceSelectorBuilder() {
        validator = new DeviceParametersValidator();
        definedParameters = new HashMap<Class<? extends DeviceParameter>, DeviceParameter>();
    }

    /**
     * Sets the minimum API level a device should have. This parameter must be consistent (lesser or equal to) with the
     * maximum API level and the defined DeviceOs, if any of them is also provided.
     * 
     * @param minApi
     *        - the minimum API level of a device, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if the specified API version is not a positive number
     */
    public DeviceSelectorBuilder minApi(int minApi) {
        ApiLevel.Minimum min = new ApiLevel.Minimum(minApi);
        validator.validateIntParameter(min);
        definedParameters.put(ApiLevel.Minimum.class, min);

        return this;
    }

    /**
     * Sets the maximum API level a device should have. This parameter must be consistent (greater or equal to) with the
     * minimum API level and the defined DeviceOs, if any of them is also provided.
     * 
     * @param minApi
     *        - the maximum API level of a device, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if the specified API version is not a positive number
     */
    public DeviceSelectorBuilder maxApi(int maxApi) {
        ApiLevel.Maximum max = new ApiLevel.Maximum(maxApi);
        validator.validateIntParameter(max);
        definedParameters.put(ApiLevel.Maximum.class, max);

        return this;
    }

    /**
     * Sets the targeted API level a device should have. This parameter has precedence over a specified (if any) API
     * range by {@link DeviceSelectorBuilder#minApi minApi} and/or {@link DeviceSelectorBuilder#maxApi maxApi} and must
     * also be consistent with each of them. If only the target API for a device is set - only devices with specifically
     * that API version will match.
     * 
     * @param targetApi
     *        - the target API level of a device, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if the specified API version is not a positive number
     */
    public DeviceSelectorBuilder targetApi(int targetApi) {
        ApiLevel.Target target = new ApiLevel.Target(targetApi);
        validator.validateIntParameter(target);
        definedParameters.put(ApiLevel.Target.class, target);

        return this;
    }

    /**
     * Sets the {@link DeviceOs OS version} a device should have. This parameter must be consistent with any other
     * specified API version parameter.
     * 
     * @param os
     *        - the OS version of a device, cannot be <code>null</code>
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if os is <code>null</code>
     */
    public DeviceSelectorBuilder deviceOs(DeviceOs os) {
        validator.validateNotNull(os);
        definedParameters.put(DeviceOs.class, os);

        return this;
    }

    /**
     * Sets the {@link DeviceType type} of a device.
     * 
     * @param type
     *        - the device`s type, cannot be <code>null</code>
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if type is <code>null</code>
     */
    public DeviceSelectorBuilder deviceType(DeviceType type) {
        validator.validateNotNull(type);
        definedParameters.put(DeviceType.class, type);

        return this;
    }

    /**
     * Sets whether a device should have a camera.
     * 
     * @param isCameraAvailable
     *        - whether or not a device should have a camera
     * @return the same instance of this {@link DeviceSelectorBuilder}
     */
    public DeviceSelectorBuilder isCameraAvailable(boolean isCameraAvailable) {
        definedParameters.put(CameraAvailable.class, new CameraAvailable(isCameraAvailable));

        return this;
    }

    /**
     * Sets the model of a device.
     * 
     * @param deviceModel
     *        - the model of the device, must be a non-empty string
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if deviceModel is <code>null</code> or is an empty string
     */
    public DeviceSelectorBuilder deviceModel(String deviceModel) {
        DeviceModel model = new DeviceModel(deviceModel);
        validator.validateStringParameter(model);
        definedParameters.put(DeviceModel.class, model);

        return this;
    }

    /**
     * Sets the RAM capacity in MB a device should have.
     * 
     * @param ramCapacity
     *        - the RAM capacity of a device in MB, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if ramCapacity is not a positive number
     */
    public DeviceSelectorBuilder ramCapacity(int ramCapacity) {
        RamCapacity ram = new RamCapacity(ramCapacity);
        validator.validateIntParameter(ram);
        definedParameters.put(RamCapacity.class, ram);

        return this;
    }

    /**
     * Sets the device`s screen resolution width in pixels.
     * 
     * @param screenWidth
     *        - the screen width in pixels, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if screenWidth is not a positive number
     */
    public DeviceSelectorBuilder screenWidth(int screenWidth) {
        ScreenParameter.Width width = new ScreenParameter.Width(screenWidth);
        validator.validateIntParameter(width);
        definedParameters.put(ScreenParameter.Width.class, width);

        return this;
    }

    /**
     * Sets the device`s screen resolution height in pixels.
     * 
     * @param screenHeight
     *        - the screen height in pixels, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if screenHeight is not a positive number
     */
    public DeviceSelectorBuilder screenHeight(int screenHeight) {
        ScreenParameter.Height height = new ScreenParameter.Height(screenHeight);
        validator.validateIntParameter(height);
        definedParameters.put(ScreenParameter.Height.class, height);

        return this;
    }

    /**
     * Sets the device`s screen DPI.
     * 
     * @param screenDpi
     *        - the screen DPI ratio, must be a positive number
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if screenDpi is not a positive number
     */
    public DeviceSelectorBuilder screenDpi(int screenDpi) {
        ScreenParameter.DPI dpi = new ScreenParameter.DPI(screenDpi);
        validator.validateIntParameter(dpi);
        definedParameters.put(ScreenParameter.DPI.class, dpi);

        return this;
    }

    /**
     * Sets the serial number of a device.
     * 
     * @param serialNumber
     *        - the serial number of the device, must be a non-empty string
     * @return the same instance of this {@link DeviceSelectorBuilder}
     * @throws ValidationException
     *         if serialNumber is <code>null</code> or is an empty string
     */
    public DeviceSelectorBuilder serialNumber(String serialNumber) {
        SerialNumber sn = new SerialNumber(serialNumber);
        validator.validateStringParameter(sn);
        definedParameters.put(SerialNumber.class, sn);

        return this;
    }

    /**
     * Gets a {@link DeviceSelector} with the previously specified parameters in this builder. After this method is
     * executed, the builder is reset and can be used again to build another {@link DeviceSelector selector}. If some of
     * the specified {@link DeviceParameter parameters} are incompatible with each other, an exception is thrown and the
     * builder is NOT reset.
     * 
     * @return validated {@link DeviceSelector}
     * @throws ValidationException
     *         if some of the specified {@link DeviceParameter parameters} are incompatible
     */
    public DeviceSelector build() {
        ApiLevel.Minimum minApi = (ApiLevel.Minimum) definedParameters.get(ApiLevel.Minimum.class);
        ApiLevel.Maximum maxApi = (ApiLevel.Maximum) definedParameters.get(ApiLevel.Maximum.class);
        ApiLevel.Target targetApi = (ApiLevel.Target) definedParameters.get(ApiLevel.Target.class);
        DeviceOs os = (DeviceOs) definedParameters.get(DeviceOs.class);

        if (minApi == null && targetApi != null) {
            minApi = new ApiLevel.Minimum(targetApi.getValue());
            definedParameters.put(ApiLevel.Minimum.class, minApi);
        }

        if (maxApi == null && targetApi != null) {
            maxApi = new ApiLevel.Maximum(targetApi.getValue());
            definedParameters.put(ApiLevel.Maximum.class, maxApi);
        }

        validator.validateCompatibility(minApi, maxApi, targetApi, os);

        DeviceSelector selector = new DeviceSelector(definedParameters);
        definedParameters.clear();

        return selector;
    }
}
