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
