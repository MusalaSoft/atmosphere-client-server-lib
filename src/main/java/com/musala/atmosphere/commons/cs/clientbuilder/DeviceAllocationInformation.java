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

package com.musala.atmosphere.commons.cs.clientbuilder;

/**
 * A structure that describes to the client's Builder instance a device that has been allocated for use.
 * 
 * @author georgi.gaydarov
 * 
 */
public class DeviceAllocationInformation {
    private long proxyPasskey;

    private String deviceId;

    /**
     * Create a instance of {@link DeviceAllocationInformation} that keeps information for a device that has been
     * allocated.
     * 
     * @param proxyPasskey
     *        - passkey to be used in the DeviceProxy method invocations
     * @param deviceId
     *        - the device ID
     */
    public DeviceAllocationInformation(Long proxyPasskey, String deviceId) {
        this.proxyPasskey = proxyPasskey;
        this.deviceId = deviceId;
    }

    /**
     * Gets the passkey to be used in the DeviceProxy method invocations.
     * 
     * @return passkey to be used in the DeviceProxy
     */
    public long getProxyPasskey() {
        return proxyPasskey;
    }

    /**
     * Gets the ID of the device.
     * 
     * @return the device ID
     */
    public String getDeviceId() {
        return deviceId;
    }
}
