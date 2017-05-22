package com.musala.atmosphere.commons.cs.util;

import com.musala.atmosphere.commons.cs.deviceselection.DeviceSelector;
import com.musala.atmosphere.commons.cs.util.deserializator.DeviceSelectorDeserializer;
import com.musala.atmosphere.commons.cs.util.serializator.DeviceSelectorSerializer;
import com.musala.atmosphere.commons.websocket.message.Message;
import com.musala.atmosphere.commons.websocket.util.GsonUtil;

/**
 * Responsible for serialization/deserialization of all {@link Message messages} that have an argument/data belonging to
 * the atmosphere-client-server-lib or atmosphere-commons project.
 *
 * @author dimcho.nedev
 *
 */
public class ClientServerGsonUtil extends GsonUtil {
    public ClientServerGsonUtil() {
        super();
        gsonBuilder.registerTypeHierarchyAdapter(DeviceSelector.class, new DeviceSelectorSerializer());
        gsonBuilder.registerTypeHierarchyAdapter(DeviceSelector.class, new DeviceSelectorDeserializer());
        g = gsonBuilder.create();
    }
}
