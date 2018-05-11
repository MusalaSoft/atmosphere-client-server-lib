// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

package com.musala.atmosphere.commons.cs.deviceselection;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.musala.atmosphere.commons.cs.deviceselection.ApiLevel;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceOs;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceParametersValidator;
import com.musala.atmosphere.commons.cs.deviceselection.RamCapacity;
import com.musala.atmosphere.commons.cs.deviceselection.SerialNumber;
import com.musala.atmosphere.commons.cs.exception.ValidationException;

/**
 * Tests for {@link DeviceParametersValidator} functionalities.
 * 
 * @author vassil.angelov
 *
 */
public class DeviceParametersValidatorTest {

    private static final String EXPECTED_EXCEPTION_FAIL_MESSAGE_FORMAT = "Expected validation exception when validating %s with %s";

    private static final String NAME_AND_VALUE_FORMAT = "%s=\"%s\"";

    private DeviceParametersValidator validator;

    @Before
    public void init() {
        validator = new DeviceParametersValidator();
    }

    @Test
    public void testValidateIntParameter() {
        RamCapacity ram = new RamCapacity(1500);

        // test with valid value
        validator.validateIntParameter(ram);

        // tests with invalid values
        ram.value = 0;
        try {
            validator.validateIntParameter(ram);
            fail(createErrorMessage("integer parameter", ram));
        } catch (ValidationException ve) {
            // expected
        }

        ram.value = -120;
        try {
            validator.validateIntParameter(ram);
            fail(createErrorMessage("integer parameter", ram));
        } catch (ValidationException ve) {
            // expected
        }

        ram.value = null;
        try {
            validator.validateIntParameter(ram);
            fail(createErrorMessage("integer parameter", ram));
        } catch (ValidationException ve) {
            // expected
        }
    }

    @Test
    public void testValidateStringParameter() {
        SerialNumber serialNumber = new SerialNumber("12383748adas98q098qw");

        // test with valid value
        validator.validateStringParameter(serialNumber);

        // test with invalid values
        serialNumber.value = "";
        try {
            validator.validateStringParameter(serialNumber);
            fail(createErrorMessage("string parameter", serialNumber));
        } catch (ValidationException ve) {
            // expected
        }

        serialNumber.value = null;
        try {
            validator.validateStringParameter(serialNumber);
            fail(createErrorMessage("string parameter", serialNumber));
        } catch (ValidationException ve) {
            // expected
        }
    }

    @Test
    public void testApiParams() {
        ApiLevel.Minimum min = new ApiLevel.Minimum(18);
        ApiLevel.Maximum max = new ApiLevel.Maximum(20);
        ApiLevel.Target target = new ApiLevel.Target(19);

        // test with valid values
        validator.validateApis(min, max, target);
        validator.validateApis(min, null, target);
        validator.validateApis(null, max, target);
        validator.validateApis(min, max, null);
        validator.validateApis(null, null, target);
        validator.validateApis(null, max, null);
        validator.validateApis(min, null, null);
        validator.validateApis(null, null, null);

        // test with invalid values

        min.value = -1;
        try {
            validator.validateApis(min, max, target);
            fail(createErrorMessage("API parameters", min, max, target));
        } catch (ValidationException ve) {
            // expected
        }

        min.value = 21;
        try {
            validator.validateApis(min, max, target);
            fail(createErrorMessage("API parameters", min, max, target));
        } catch (ValidationException ve) {
            // expected
        }

        min.value = 18;
        target.value = 17;
        try {
            validator.validateApis(min, max, target);
            fail(createErrorMessage("API parameters", min, max, target));
        } catch (ValidationException ve) {
            // expected
        }
    }

    @Test
    public void testApiAndOsCompatibility() {
        ApiLevel.Minimum min = new ApiLevel.Minimum(18);
        ApiLevel.Maximum max = new ApiLevel.Maximum(20);
        ApiLevel.Target target = new ApiLevel.Target(19);
        DeviceOs os = DeviceOs.KITKAT_4_4;

        // test with valid values
        validator.validateCompatibility(min, max, target, os);
        validator.validateCompatibility(min, max, null, os);
        validator.validateCompatibility(min, max, target, null);
        validator.validateCompatibility(min, max, null, null);
        validator.validateCompatibility(null, max, target, os);
        validator.validateCompatibility(min, null, target, os);
        validator.validateCompatibility(null, null, target, os);
        validator.validateCompatibility(null, null, null, os);
        validator.validateCompatibility(null, null, null, null);

        // test with invalid values
        os = DeviceOs.LOLLIPOP_5_0_2;

        try {
            validator.validateCompatibility(min, max, target, os);
            fail(createErrorMessage("API and OS compatibility", min, max, target, os));
        } catch (ValidationException ve) {
            // expected
        }
    }

    private String createErrorMessage(String validationType, DeviceParameter... deviceParameters) {
        StringBuilder parameterValuesBuilder = new StringBuilder();
        for (DeviceParameter deviceParameter : deviceParameters) {
            String value = null;
            if (deviceParameter instanceof SingleValueDeviceParameter) {
                value = ((SingleValueDeviceParameter<?>) deviceParameter).value.toString();
            } else {
                value = deviceParameter.toString();
            }

            parameterValuesBuilder.append(' ');
            parameterValuesBuilder.append(String.format(NAME_AND_VALUE_FORMAT, deviceParameter.getClass()
                                                                                              .getSimpleName(), value));
        }
        parameterValuesBuilder.append('.');

        return String.format(EXPECTED_EXCEPTION_FAIL_MESSAGE_FORMAT, validationType, parameterValuesBuilder.toString());
    }
}
