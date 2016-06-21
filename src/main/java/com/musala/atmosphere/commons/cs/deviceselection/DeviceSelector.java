package com.musala.atmosphere.commons.cs.deviceselection;

import java.io.Serializable;
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
public class DeviceSelector implements Serializable {

    private static final long serialVersionUID = -4906043158195925300L;

    private HashMap<Class<? extends DeviceParameter>, DeviceParameter> deviceParameters;

    /**
     * Creates new {@link DeviceSelector} with the specified parameters.
     * 
     * @param parameters
     */
    DeviceSelector(Map<Class<? extends DeviceParameter>, DeviceParameter> parameters) {
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
