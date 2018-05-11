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
 * Describes {@link DeviceParameter} related to the screen of a device.
 * 
 * @author vassil.angelov
 *
 */
public abstract class ScreenParameter extends SingleValueDeviceParameter<Integer> {
    /**
     * The width in pixels of a device`s screen represented as a {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public static class Width extends ScreenParameter {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Width(int width) {
            value = width;
        }

    }

    /**
     * The height in pixels of a device`s screen represented as a {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public static class Height extends ScreenParameter {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Height(int height) {
            value = height;
        }
    }

    /**
     * The DPI of a device`s screen represented as a {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public static class DPI extends ScreenParameter {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        DPI(int dpi) {
            value = dpi;
        }

    }
}
