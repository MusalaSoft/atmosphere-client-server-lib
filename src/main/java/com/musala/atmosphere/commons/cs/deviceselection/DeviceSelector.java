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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.musala.atmosphere.commons.cs.deviceselection.DeviceParameter.Visitor;

/**
 * A selector that can be used to search for specific device(s) that match the defined {@link DeviceParameter device
 * parameters}.
 *
 * @author vassil.angelov
 *
 */
public class DeviceSelector {
    private HashMap<Class<? extends DeviceParameter>, DeviceParameter> deviceParameters;

    /**
     * Creates new {@link DeviceSelector} with the specified parameters.
     *
     * @param parameters
     */
    public DeviceSelector(Map<Class<? extends DeviceParameter>, DeviceParameter> parameters) {
        deviceParameters = new HashMap<Class<? extends DeviceParameter>, DeviceParameter>(parameters);
    }

    /**
     * Iterates over all defined parameters in this selector using the provided {@link Visitor}.
     *
     * @param visitor
     *        - the {@link Visitor} to use when iterating the parameters
     */
    public void visitAll(Visitor visitor) {
        for (DeviceParameter parameter : deviceParameters.values()) {
            parameter.accept(visitor);
        }
    }

    @Override
    public String toString() {
        StringBuilder selectorRepresentation = new StringBuilder();

        for (Entry<Class<? extends DeviceParameter>, DeviceParameter> parameterPair : deviceParameters.entrySet()) {
            String parameterRepresentation = String.format("%s = %s; ",
                                                           parameterPair.getKey().getSimpleName(),
                                                           parameterPair.getValue());
            selectorRepresentation.append(parameterRepresentation);
        }

        return selectorRepresentation.toString();
    }

    /**
     * Retrieve the defined {@link DeviceParameter device parameters} for this selector.
     *
     * @return The defined {@link DeviceParameter device parameters} for this selector
     */
    public Map<Class<? extends DeviceParameter>, DeviceParameter> getParameters() {
        return new HashMap<Class<? extends DeviceParameter>, DeviceParameter>(deviceParameters);
    }
}
