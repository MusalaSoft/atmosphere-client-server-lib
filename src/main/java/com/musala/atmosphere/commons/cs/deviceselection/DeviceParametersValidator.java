package com.musala.atmosphere.commons.cs.deviceselection;

import com.musala.atmosphere.commons.cs.exception.ValidationException;

/**
 * Class providing validation for {@link DeviceParameter}.
 * 
 * @author vassil.angelov
 *
 */
public class DeviceParametersValidator {

    /**
     * Validates that a parameter is not <code>null</code>.
     * 
     * @param parameter
     *        - the parameter to check
     * @throws ValidationException
     *         when <code>parameter == null</code>
     */
    public void validateNotNull(DeviceParameter parameter) {
        if (parameter == null) {
            throw new ValidationException("DeviceParameter cannot be null.");
        }
    }

    /**
     * Validates that a parameter and its value are not null.
     * 
     * @param parameter
     *        - the parameter to check
     * @throws ValidationException
     *         when <code>parameter == null</code> or <code>parameter.getValue() == null</code>
     */
    public void validateNotNull(SingleValueDeviceParameter<? extends Object> parameter) {
        validateNotNull((DeviceParameter) parameter);
        if (parameter.value == null) {
            throw new ValidationException("DeviceParameter value cannot be null.");
        }
    }

    /**
     * Validates that a single number value parameter has value greater than 0.
     * 
     * @param parameter
     *        - the parameter to check
     * @throws ValidationException
     *         when the value of the parameter is not a positive number
     */
    public void validatePositiveValue(SingleValueDeviceParameter<? extends Number> parameter) {
        if (parameter.value.doubleValue() <= 0d) {
            throw new ValidationException(parameter.getClass().getSimpleName() + " must have a value greater than 0.");
        }
    }

    /**
     * Validates that a single string value parameter has non-empty string value.
     * 
     * @param parameter
     *        - the parameter to check
     * @throws ValidationException
     *         when a parameter with an empty string value is provided
     */
    public void validateNotEmpty(SingleValueDeviceParameter<String> parameter) {
        if (parameter.value.isEmpty()) {
            throw new ValidationException(parameter.getClass().getSimpleName() + " must have a non-empty string value.");
        }
    }

    /**
     * Validates a device parameter with an integer value. All such parameters must have positive values.
     * 
     * @param integerParameter
     *        - the parameter to check
     * @throws ValidationException
     *         when a parameter with a non-positive value is provided or when the parameter is <code>null</code>
     */
    public void validateIntParameter(SingleValueDeviceParameter<Integer> integerParameter) {
        validateNotNull(integerParameter);
        validatePositiveValue(integerParameter);
    }

    /**
     * Validates a device parameter with a string value. All such parameters must have a non-empty string values.
     * 
     * @param stringParameter
     *        - the parameter to check
     * @throws ValidationException
     *         when a parameter with an empty string value is provided or when the parameter is <code>null</code>
     */
    public void validateStringParameter(SingleValueDeviceParameter<String> stringParameter) {
        validateNotNull(stringParameter);
        validateNotEmpty(stringParameter);
    }

    /**
     * Validates that the provided {@link ApiLevel} parameters are consistent. All parameters are optional and can be
     * <code>null</code>, but if defined they must be logically consistent. More specifically the following must be true
     * for all defined parameters <code>minApi <= targetApi <= maxApi</code> .
     * 
     * @param minApi
     *        - the minimum API version or <code>null</code>
     * @param maxApi
     *        - the maximum API version or <code>null</code>
     * @param targetApi
     *        - the target API version or <code>null</code>
     * @throws ValidationException
     *         if the provided API parameters are inconsistent
     */
    public void validateApis(ApiLevel.Minimum minApi, ApiLevel.Maximum maxApi, ApiLevel.Target targetApi) {
        if (minApi == null) {
            minApi = new ApiLevel.Minimum(1);
        } else {
            validateIntParameter(minApi);
        }

        if (maxApi == null) {
            maxApi = new ApiLevel.Maximum(Integer.MAX_VALUE);
        } else {
            validateIntParameter(maxApi);
        }

        if (maxApi.value < minApi.value) {
            throw new ValidationException("Api level is inconsitent. Min API level is "
                    + Integer.toString(minApi.value) + " but the max API level is " + Integer.toString(maxApi.value)
                    + ".");
        }

        if (targetApi != null && (maxApi.value < targetApi.value || minApi.value > targetApi.value)) {
            throw new ValidationException("Api level is inconsitent. Target API is "
                    + Integer.toString(targetApi.value) + ", but the defined API range is ["
                    + Integer.toString(minApi.value) + "-" + Integer.toString(maxApi.value) + "].");
        }
    }

    /**
     * Validates that the provided API levels and {@link DeviceOs} are compatible. Every {@link DeviceOs} is linked to a
     * specific API version, which must be in the range defined by {@link ApiLevel.MinApi} and {@link ApiLevel.MaxApi}
     * and match the {@link ApiLevel.Target}. All parameters are optional and can be <code>null</code>, but if defined
     * they must be compatible.
     * 
     * @param minApi
     *        - the minimum API version or <code>null</code>
     * @param maxApi
     *        - the maximum API version or <code>null</code>
     * @param targetApi
     *        - the targeted API version or <code>null</code>
     * @param os
     *        - the OS of the device or <code>null</code>
     * @throws ValidationException
     *         if the defined parameters are not compatible
     */
    public void validateCompatibility(ApiLevel.Minimum minApi,
                                      ApiLevel.Maximum maxApi,
                                      ApiLevel.Target targetApi,
                                      DeviceOs os) {
        validateApis(minApi, maxApi, targetApi);

        if (os != null && targetApi != null && targetApi.value != os.getApiLevel()) {
            throw new ValidationException("Api target level and DeviceOs are inconsitent. Specified os has API  "
                    + Integer.toString(os.getApiLevel()) + ", but the API target is "
                    + Integer.toString(targetApi.value) + ".");
        }

        ApiLevel.Target targetOs = os == null ? null : new ApiLevel.Target(os.getApiLevel());
        try {
            validateApis(minApi, maxApi, targetOs);
        } catch (ValidationException ve) {
            throw new ValidationException("Api level and DeviceOs are inconsitent. Specified os has API  "
                    + Integer.toString(os.getApiLevel()) + ", but the defined API range is ["
                    + Integer.toString(minApi.value) + "-" + Integer.toString(maxApi.value) + "].");
        }
    }
}
