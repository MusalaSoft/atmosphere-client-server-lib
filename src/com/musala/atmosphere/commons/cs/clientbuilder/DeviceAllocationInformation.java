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

    /**
     * 
     * @param proxyRmiId
     *        - DeviceProxy's RMI binding identifier.
     * @param proxyPasskey
     *        - passkey to be used in the DeviceProxy method invocations.
     */
    public DeviceAllocationInformation(String proxyRmiId, Long proxyPasskey) {
        this.proxyRmiId = proxyRmiId;
        this.proxyPasskey = proxyPasskey;
    }

    /**
     * 
     * @return the allocated device's DeviceProxy RMI binding identifier.
     */
    public String getProxyRmiId() {
        return proxyRmiId;
    }

    /**
     * 
     * @return the passkey to be used in the DeviceProxy method invocations.
     */
    public long getProxyPasskey() {
        return proxyPasskey;
    }
}
