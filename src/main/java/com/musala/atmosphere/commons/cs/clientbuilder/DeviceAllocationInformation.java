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
