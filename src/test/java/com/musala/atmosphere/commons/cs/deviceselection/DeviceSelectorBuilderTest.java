package com.musala.atmosphere.commons.cs.deviceselection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.musala.atmosphere.commons.cs.exception.ValidationException;

/**
 * 
 * @author vassil.angelov
 *
 */
public class DeviceSelectorBuilderTest {

    private static final int VALID_SCREEN_WIDTH = 320;

    private static final int VALID_SCREEN_HEIGHT = 500;

    private static final int VALID_SCREEN_DPI = 30;

    private static final int INVALID_SCREEN_DPI = -230;

    private static final String VALID_DEVICE_MODEL = "Alpha Universe Optimus Prime ZXY 9";

    private static final String VALID_SERIAL_NUMBER = "asdaertsxcv3231";

    private static final String WRONG_DEVICE_PARAMETERS_COUNT_FORMAT = "Expected device selector with %d parameters, but it had %d.";

    private DeviceSelectorBuilder builder;

    @Before
    public void init() {
        builder = new DeviceSelectorBuilder();
    }

    @Test
    public void testSingleParameterSelector() {
        builder.screenWidth(320);

        DeviceSelector selector = builder.build();

        assertTrue("Device selector was expected to have a screen width parameter.",
                   selector.getParameters().containsKey(ScreenParameter.Width.class));
    }

    @Test
    public void testAllParametersSelector() {
        builder.minApi(18)
               .maxApi(20)
               .targetApi(19)
               .deviceModel(VALID_DEVICE_MODEL)
               .deviceOs(DeviceOs.KITKAT_4_4_4)
               .isCameraAvailable(true)
               .deviceType(DeviceType.DEVICE_ONLY)
               .serialNumber(VALID_SERIAL_NUMBER)
               .ramCapacity(1500)
               .screenDpi(VALID_SCREEN_DPI)
               .screenHeight(VALID_SCREEN_HEIGHT)
               .screenWidth(VALID_SCREEN_WIDTH);

        DeviceSelector selector = builder.build();

        int definedParametersCount = 12;
        int selectorParametersCount = selector.getParameters().size();
        assertEquals(String.format(WRONG_DEVICE_PARAMETERS_COUNT_FORMAT,
                                   definedParametersCount,
                                   selectorParametersCount), selectorParametersCount, definedParametersCount);
    }

    @Test(expected = ValidationException.class)
    public void testIncompatibleParameters() {
        builder.minApi(20).maxApi(21).deviceOs(DeviceOs.JELLY_BEAN_4_1);

        builder.build();
    }

    @Test
    public void testInvalidParameter() {
        boolean isExceptionThrown = false;

        try {
            builder.deviceOs(DeviceOs.KITKAT_4_4_1)
                   .serialNumber(VALID_SERIAL_NUMBER)
                   .screenDpi(INVALID_SCREEN_DPI)
                   .deviceModel(VALID_DEVICE_MODEL);
        } catch (ValidationException ve) {
            isExceptionThrown = true;
        }

        assertTrue("Expected a validation exception, but it did not occur.", isExceptionThrown);

        DeviceSelector selector = builder.build();

        assertNull("Device selector has been built with invalid parameter.",
                   selector.getParameters().get(ScreenParameter.DPI.class));

        int expectedParametersCount = 2;
        int selectorParametersCount = selector.getParameters().size();
        assertEquals(String.format(WRONG_DEVICE_PARAMETERS_COUNT_FORMAT,
                                   expectedParametersCount,
                                   selectorParametersCount), expectedParametersCount, selectorParametersCount);
    }

}
