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
 * This enumeration contains all possible values for devices' OS.
 * 
 * @author yavor.stankov
 * 
 */

public enum DeviceOs implements DeviceParameter {
    /**
     * <i><b>Android 4.1</b></i>
     */
    JELLY_BEAN_4_1("4.1", 16),

    /**
     * <i><b>Android 4.2.1</b></i>
     */
    JELLY_BEAN_MR1_4_2_1("4.2.1", 17),

    /**
     * <i><b>Android 4.2.2</b></i>
     */
    JELLY_BEAN_MR1_4_2_2("4.2.2", 17),

    /**
     * <i><b>Android 4.3</b></i>
     */
    JELLY_BEAN_MR2_4_3("4.3", 18),

    /**
     * <i><b>Android 4.4</b></i>
     */
    KITKAT_4_4("4.4", 19),

    /**
     * <i><b>Android 4.4.1</b></i>
     */
    KITKAT_4_4_1("4.4.1", 19),

    /**
     * <i><b>Android 4.4.2</b></i>
     */
    KITKAT_4_4_2("4.4.2", 19),

    /**
     * <i><b>Android 4.4.2</b></i>
     */
    KITKAT_4_4_3("4.4.3", 19),

    /**
     * <i><b>Android 4.4.4</b></i>
     */
    KITKAT_4_4_4("4.4.4", 19),

    /**
     * <i><b>Android 5.0</b></i>
     */
    LOLLIPOP_5("5.0", 21),

    /**
     * <i><b>Android 5.0.1</b></i>
     */
    LOLLIPOP_5_0_1("5.0.1", 21),

    /**
     * <i><b>Android 5.0.2</b></i>
     */
    LOLLIPOP_5_0_2("5.0.2", 21);

    private String deviceOs;

    private int apiLevel;

    private DeviceOs(String deviceOs, int apiLevel) {
        this.deviceOs = deviceOs;
        this.apiLevel = apiLevel;
    }

    /**
     * Gets the API level for the given operating system version.
     * 
     * @return the API level for the given operating system version.
     */
    public int getApiLevel() {
        return apiLevel;
    }

    @Override
    public String toString() {
        return deviceOs;
    }

    public static DeviceOs getDeviceOs(String os) {
        for (DeviceOs currentOs : DeviceOs.values()) {
            if (os.equals(currentOs.toString())) {
                return currentOs;
            }
        }

        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
