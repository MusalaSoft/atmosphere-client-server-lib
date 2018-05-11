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

/**
 * Enumeration with all possible choices for requesting physical presence of device - <i>EMULATOR_ONLY</i>,
 * <i>DEVICE_ONLY</i>, <i>EMULATOR_PREFERRED</i>, <i>DEVICE_PREFERRED</i> or <i>NO_PREFERENCE</i>.
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum DeviceType implements DeviceParameter {
    /**
     * <i><b>EMULATOR_ONLY</b></i>
     */
    EMULATOR_ONLY("emulator_only"),

    /**
     * <i><b>DEVICE_ONLY</b></i>
     */
    DEVICE_ONLY("device_only"),

    /**
     * <i><b>EMULATOR_PREFERRED</b></i>
     */
    EMULATOR_PREFERRED("emulator_preferred"),

    /**
     * <i><b>DEVICE_PREFERRED</b></i>
     */
    DEVICE_PREFERRED("device_preferred");

    private String value;

    private DeviceType(String deviceType) {
        this.value = deviceType;
    }

    @Override
    public String toString() {
        return value;
    }

    public static DeviceType getDeviceType(String type) {
        switch (type) {
            case "emulator_only":
                return EMULATOR_ONLY;
            case "device_only":
                return DEVICE_ONLY;
            case "emulator_preferred":
                return EMULATOR_PREFERRED;
            case "device_preferred":
                return DEVICE_PREFERRED;
            default:
                return null;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
