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
 * Describes {@link DeviceParameter} related to the Android SDK API of a device.
 *
 * @author vassil.angelov
 *
 */
public abstract class ApiLevel extends SingleValueDeviceParameter<Integer> {
    /**
     * The maximum API a device can have.
     *
     * @author vassil.angelov
     *
     */
    public static class Maximum extends ApiLevel {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Maximum(int apiLevel) {
            value = apiLevel;
        }
    }

    /**
     * The minimum API a device can have.
     *
     * @author vassil.angelov
     *
     */
    public static class Minimum extends ApiLevel {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Minimum(int apiLevel) {
            value = apiLevel;
        }
    }

    /**
     * The targeted API a device can have. In case this parameter is present along with both (or one of)
     * {@link ApiLevel.Maximum} or {@link ApiLevel.Minimum}, the target is considered with higher priority.
     *
     * @author vassil.angelov
     *
     */
    public static class Target extends ApiLevel {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Target(int apiLevel) {
            value = apiLevel;
        }
    }

}
