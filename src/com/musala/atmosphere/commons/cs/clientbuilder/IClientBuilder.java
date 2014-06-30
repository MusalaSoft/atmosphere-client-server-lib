package com.musala.atmosphere.commons.cs.clientbuilder;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.musala.atmosphere.commons.cs.InvalidPasskeyException;

/**
 * Used implicitly by the client's Builder to get available devices which have given device properties. The Builder
 * connects through RMI to the PoolManager on the Server and asks for an available device. The PoolManager searches for
 * device with given DeviceParameters and returns it's RMI identifier. If no suitable device is found, then an emulator
 * with the requested DeviceParameters could be created and returned.
 * 
 * @author vladimir.vladimirov
 * 
 */

public interface IClientBuilder extends Remote {
    /**
     * Returns {@link DeviceAllocationInformation DeviceAllocationInformation} descriptor structure of an available
     * device with given properties to be used by the client.
     * 
     * @param deviceParameters
     *        - requested device parameters.
     * @return {@link DeviceAllocationInformation DeviceAllocationInformation} descriptor of a device with requested
     *         properties.
     * @throws RemoteException
     *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
     *         connection, missing method or something else.
     */
    public DeviceAllocationInformation allocateDevice(DeviceParameters deviceParameters) throws RemoteException;

    /**
     * Releases allocated device from a Client and returns it in the pool.
     * 
     * @param allocatedDeviceDescriptor
     *        - the descriptor that was returned when the device was allocated.
     * @throws RemoteException
     * @throws InvalidPasskeyException
     */
    public void releaseDevice(DeviceAllocationInformation allocatedDeviceDescriptor)
        throws RemoteException,
            InvalidPasskeyException;
}
