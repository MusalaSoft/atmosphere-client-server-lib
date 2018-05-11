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

package com.musala.atmosphere.commons.cs.util.deserializator;

import static com.musala.atmosphere.commons.websocket.util.JsonConst.FAILED_TO_FIND_CLASS;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.KEY;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.VALUE;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceParameter;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceSelector;

/**
 * Deserializer for the {@link DeviceSelector} object.
 *
 * @author alexander.ivanov
 *
 */
public class DeviceSelectorDeserializer implements JsonDeserializer<DeviceSelector> {
    private final static Logger LOGGER = Logger.getLogger(DeviceSelectorDeserializer.class);

    @SuppressWarnings("unchecked")
    @Override
    public DeviceSelector deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {

        Map<Class<? extends DeviceParameter>, DeviceParameter> params = new HashMap<>();
        JsonArray jsonArray = json.getAsJsonArray();

        for (JsonElement jsonElement : jsonArray) {
            String className = jsonElement.getAsJsonObject().get(KEY).getAsString();
            Class<? extends DeviceParameter> clazz = null;
            try {
                clazz = (Class<? extends DeviceParameter>) Class.forName(className);
            } catch (ClassNotFoundException e) {
                LOGGER.error(String.format(FAILED_TO_FIND_CLASS, className), e);
            }

            JsonElement value = jsonElement.getAsJsonObject().get(VALUE);
            DeviceParameter pair = context.deserialize(value, clazz);
            params.put(clazz, pair);
        }

        DeviceSelector deviceSelector = new DeviceSelector(params);

        return deviceSelector;
    }

}
