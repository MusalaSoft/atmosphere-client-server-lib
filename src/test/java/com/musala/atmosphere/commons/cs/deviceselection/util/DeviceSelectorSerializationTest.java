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

package com.musala.atmosphere.commons.cs.deviceselection.util;

import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.musala.atmosphere.commons.cs.deviceselection.ApiLevel.Maximum;
import com.musala.atmosphere.commons.cs.deviceselection.ApiLevel.Target;
import com.musala.atmosphere.commons.cs.deviceselection.CameraAvailable;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceModel;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceOs;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceParameter;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceSelector;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceSelectorBuilder;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceType;
import com.musala.atmosphere.commons.cs.deviceselection.RamCapacity;
import com.musala.atmosphere.commons.cs.deviceselection.ScreenParameter;
import com.musala.atmosphere.commons.cs.deviceselection.SerialNumber;
import com.musala.atmosphere.commons.cs.util.deserializator.DeviceSelectorDeserializer;
import com.musala.atmosphere.commons.cs.util.serializator.DeviceSelectorSerializer;

/**
 * Tests for {@link DeviceSelector} serialization/deserialization.
 * 
 * @author dimcho.nedev
 *
 */
public class DeviceSelectorSerializationTest {
    private static final int VALID_MAX_API = 20;

    private static final int VALID_TARGET_API = 19;

    private static final int VALID_RAM = 1500;

    private static final int VALID_SCREEN_DPI = 30;

    private static final int VALID_SCREEN_HEIGHT = 500;

    private static final int VALID_SCREEN_WIDTH = 320;

    private static final String VALID_DEVICE_MODEL = "Alpha Universe Optimus Prime ZXY 9";

    private static final String VALID_SERIAL_NUMBER = "asdaertsxcv3231";

    private static Gson g;

    @BeforeClass
    public static void setUp() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeHierarchyAdapter(DeviceSelector.class, new DeviceSelectorSerializer());
        builder.registerTypeHierarchyAdapter(DeviceSelector.class, new DeviceSelectorDeserializer());
        g = builder.create();
    }

    @Test
    public void deviceSelectorTypeAdapterTest() {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder();
        DeviceSelector deviceSelector = builder.maxApi(VALID_MAX_API)
                                               .targetApi(VALID_TARGET_API)
                                               .deviceModel(VALID_DEVICE_MODEL)
                                               .deviceOs(DeviceOs.KITKAT_4_4_4)
                                               .isCameraAvailable(true)
                                               .deviceType(DeviceType.DEVICE_ONLY)
                                               .serialNumber(VALID_SERIAL_NUMBER)
                                               .ramCapacity(VALID_RAM)
                                               .screenDpi(VALID_SCREEN_DPI)
                                               .screenHeight(VALID_SCREEN_HEIGHT)
                                               .screenWidth(VALID_SCREEN_WIDTH)
                                               .build();

        String json = g.toJson(deviceSelector);
        DeviceSelector actualSelector = g.fromJson(json, DeviceSelector.class);

        Map<Class<? extends DeviceParameter>, DeviceParameter> actualMap = actualSelector.getParameters();

        Assert.assertEquals(VALID_MAX_API, getAsInteger(actualMap.get(Maximum.class)));
        Assert.assertEquals(VALID_TARGET_API, getAsInteger(actualMap.get(Target.class)));
        Assert.assertEquals(VALID_DEVICE_MODEL, actualMap.get(DeviceModel.class).toString());
        Assert.assertEquals(DeviceOs.KITKAT_4_4_4, actualMap.get(DeviceOs.class));
        Assert.assertTrue(Boolean.parseBoolean(actualMap.get(CameraAvailable.class).toString()));
        Assert.assertEquals(DeviceType.DEVICE_ONLY, actualMap.get(DeviceType.class));
        Assert.assertEquals(VALID_SERIAL_NUMBER, actualMap.get(SerialNumber.class).toString());
        Assert.assertEquals(VALID_RAM, getAsInteger(actualMap.get(RamCapacity.class)));
        Assert.assertEquals(VALID_SCREEN_DPI, getAsInteger(actualMap.get(ScreenParameter.DPI.class)));
        Assert.assertEquals(VALID_SCREEN_HEIGHT, getAsInteger(actualMap.get(ScreenParameter.Height.class)));
        Assert.assertEquals(VALID_SCREEN_WIDTH, getAsInteger(actualMap.get(ScreenParameter.Width.class)));
    }

    private int getAsInteger(DeviceParameter deviceParameter) {
        return Integer.parseInt(deviceParameter.toString());
    }

}
