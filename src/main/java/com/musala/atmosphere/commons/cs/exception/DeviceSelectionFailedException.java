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

package com.musala.atmosphere.commons.cs.exception;

import com.musala.atmosphere.commons.cs.deviceselection.DeviceParameter;

/**
 * Exception indicating that a certain {@link DeviceParameter device parameter} was not successfully visited and
 * appended to the device selection query.
 * 
 * @author filareta.yordanova
 * 
 */
public class DeviceSelectionFailedException extends RuntimeException {
    private static final long serialVersionUID = 3393704420154975836L;

    public DeviceSelectionFailedException() {
        super();
    }

    public DeviceSelectionFailedException(String message) {
        super(message);
    }

    public DeviceSelectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceSelectionFailedException(Throwable cause) {
        super(cause);
    }

}
