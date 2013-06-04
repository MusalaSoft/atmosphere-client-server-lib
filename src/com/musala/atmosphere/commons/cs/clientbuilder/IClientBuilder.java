package com.musala.atmosphere.commons.cs.clientbuilder;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Used implicitly by the client's Builder to get available devices which have given device properties. It connects
 * through RMI with the Pool manager from the Server side and retrieves information about all available devices from
 * there. After that it searches for device with the given DeviceParameters and selects it. If no such is found, then
 * new emulator with the requested DeviceParameters is created and then selected. Finally returns the ID of the selected
 * device.
 * 
 * @author vladimir.vladimirov
 * 
 */

public interface IClientBuilder extends Remote
{
	/**
	 * Returns ID of device which has given properties and is available for use by the QA.
	 * 
	 * @param deviceParameters
	 *        - requested device properties
	 * @return <b>String</b> - ID of device with requested properties in RMI
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public String getDeviceProxyRmiId(DeviceParameters deviceParameters) throws RemoteException;

}
