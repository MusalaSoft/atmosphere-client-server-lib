package com.musala.atmosphere.commons.cs.clientbuilder;

import java.io.Serializable;

/**
 * A structure that describes to the client's Builder instance a device that has been allocated for use.
 * 
 * @author georgi.gaydarov
 * 
 */
public class DeviceAllocationInformation implements Serializable {

    /**
     * auto generated serialization id
     */
    private static final long serialVersionUID = 8870925753196812717L;

    private String proxyRmiId;

    private long proxyPasskey;

    private String deviceId;

    /**
     * Create a instance of {@link DeviceAllocationInformation} that keeps information for a device that has been
     * allocated.
     * 
     * @param proxyRmiId
     *        - DeviceProxy's RMI binding identifier
     * @param proxyPasskey
     *        - passkey to be used in the DeviceProxy method invocations
     * @param deviceId
     *        - the device ID
     */
    public DeviceAllocationInformation(String proxyRmiId, Long proxyPasskey, String deviceId) {
        this.proxyRmiId = proxyRmiId;
        this.proxyPasskey = proxyPasskey;
        this.deviceId = deviceId;
    }

    /**
     * Gets the allocated device's DeviceProxy RMI binding identifier.
     * 
     * @return DeviceProxy RMI binding identifier.
     */
    public String getProxyRmiId() {
        return proxyRmiId;
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
