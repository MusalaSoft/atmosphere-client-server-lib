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
 * Abstraction over a single valued implementations of {@link DeviceParameter}.
 * 
 * @author vassil.angelov
 * 
 * @param <T>
 *        - the type of the parameter`s value
 */
public abstract class SingleValueDeviceParameter<T> implements DeviceParameter {
    T value;

    /**
     * Retrieve the value of this device parameter.
     * 
     * @return the value of this device parameter
     */
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
