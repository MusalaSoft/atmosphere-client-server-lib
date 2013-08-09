package com.musala.atmosphere.commons.cs.clientbuilder;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Used implicitly by the client's Builder to get available devices which have given device properties. The Builder
 * connects through RMI to the PoolManager on the Server and asks for an available device. The PoolManager searches for
 * device with given DeviceParameters and returns it's RMI identifier. If no suitable device is found, then an emulator
 * with the requested DeviceParameters could be created and returned.
 * 
 * @author vladimir.vladimirov
 * 
 */

public interface IClientBuilder extends Remote
{
	/**
	 * Returns the RMI ID of an available device with given properties to be used by the client.
	 * 
	 * @param deviceParameters
	 *        - requested device parameters.
	 * @return <b>String</b> - RMI binding ID of a device with requested properties.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public String getDeviceProxyRmiId(DeviceParameters deviceParameters) throws RemoteException;

	/**
	 * Releases allocated device from a Client and returns it in the pool.
	 * 
	 * @param rmiId
	 *        - RMI string identifier for the device.
	 */
	public void releaseDevice(String rmiId) throws RemoteException;
}
