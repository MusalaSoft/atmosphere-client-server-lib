package com.musala.atmosphere.commons.cs.util.serializator;

import static com.musala.atmosphere.commons.websocket.util.JsonConst.KEY;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.VALUE;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceParameter;
import com.musala.atmosphere.commons.cs.deviceselection.DeviceSelector;

/**
 * Serializer for the {@link DeviceSelector} object.
 *
 * @author alexander.ivanov
 *
 */
public class DeviceSelectorSerializer implements JsonSerializer<DeviceSelector> {

    @Override
    public JsonElement serialize(DeviceSelector deviceSelector, Type type, JsonSerializationContext context) {
        Map<Class<? extends DeviceParameter>, DeviceParameter> params = deviceSelector.getParameters();

        JsonArray jsonArray = new JsonArray();

        for (Map.Entry<Class<? extends DeviceParameter>, DeviceParameter> entry : params.entrySet()) {
            JsonObject pair = new JsonObject();
            pair.addProperty(KEY, entry.getValue().getClass().getName());
            pair.add(VALUE, context.serialize(entry.getValue()));

            jsonArray.add(pair);
        }

        return jsonArray;
    }

}
