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

import com.musala.atmosphere.commons.exceptions.AtmosphereRuntimeException;

/**
 * Thrown when creation of an emulator device fails.
 * 
 * @author yordan.petrov
 * 
 */
public class EmulatorCreationFailedException extends AtmosphereRuntimeException {
    // TODO: it's good to have a root RE exception in our app. Maybe it is good to introduce this intermediate level so
    // people can guard against multiple of our REs in the same time
    private static final long serialVersionUID = -2665753514724505625L;

    public EmulatorCreationFailedException() {
        super();
    }

    public EmulatorCreationFailedException(String message) {
        super(message);
    }

    public EmulatorCreationFailedException(String message, Throwable inner) {
        super(message, inner);
    }

}
