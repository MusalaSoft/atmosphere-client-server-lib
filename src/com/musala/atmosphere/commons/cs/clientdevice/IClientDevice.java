package com.musala.atmosphere.commons.cs.clientdevice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.musala.atmosphere.commons.BatteryState;
import com.musala.atmosphere.commons.CommandFailedException;
import com.musala.atmosphere.commons.ConnectionType;
import com.musala.atmosphere.commons.DeviceAcceleration;
import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.DeviceOrientation;
import com.musala.atmosphere.commons.MobileDataState;
import com.musala.atmosphere.commons.Pair;
import com.musala.atmosphere.commons.ScreenOrientation;
import com.musala.atmosphere.commons.cs.InvalidPasskeyException;

/**
 * Common interface for the user's actions. Used in the RMI connection between Client and Server.
 * 
 * @author vladimir.vladimirov
 * 
 */

public interface IClientDevice extends Remote
{
	/**
	 * Gets the amount of usable RAM of the user's device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return int - usable RAM on testing device in MB
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public long getFreeRam(long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Sends shell-command formated instruction to the Server for execution on testing device.
	 * 
	 * @param shellCommand
	 *        Executable shell command as a String.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 * 
	 */
	public String executeShellCommand(String shellCommand, long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Sends sequence of shell commands to be executed on the testing device.
	 * 
	 * @param commands
	 *        - List of the commands to be executed
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public List<String> executeSequenceOfShellCommands(List<String> commands, long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Prepares the testing device for future installation of the tested application.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws IOException
	 * @throws InvalidPasskeyException
	 */
	public void initApkInstall(long invocationPasskey) throws RemoteException, IOException, InvalidPasskeyException;

	/**
	 * Receives packet of bytes from the testing application's installation file and appends them to the .apk on the
	 * testing device's side.
	 * 
	 * @param bytes
	 *        - next portion of bytes of the apk file to be transported to the device
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws IOException
	 * @throws InvalidPasskeyException
	 */
	public void appendToApk(byte[] bytes, long invocationPasskey)
		throws RemoteException,
			IOException,
			InvalidPasskeyException;

	/**
	 * Gets together all pieces of byte packages in one .apk file and installs it to the current device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws IOException
	 * @throws InvalidPasskeyException
	 */
	public void buildAndInstallApk(long invocationPasskey)
		throws RemoteException,
			IOException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Removes all traces from installation file from the testing device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws InvalidPasskeyException
	 */
	public void discardApk(long invocationPasskey) throws RemoteException, InvalidPasskeyException;

	/**
	 * Returns String, which holds all screen widget's properties.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return XML of the screen's structure formated as a String
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public String getUiXml(long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Gets screenshot of testing device's screen.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return - screenshot image as byte array
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public byte[] getScreenshot(long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Sets network upload and download speeds on device. Measure unit is KB.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @param speeds
	 *        - pair of type < uploadSpeed, downloadSpeed >
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public void setNetworkSpeed(Pair<Integer, Integer> speeds, long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Gets network speed of testing device as a pair of Integers. Measure unit is KB.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return - pair of type < uploadSpeed, downloadSpeed >
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws InvalidPasskeyException
	 */
	public Pair<Integer, Integer> getNetworkSpeed(long invocationPasskey)
		throws RemoteException,
			InvalidPasskeyException;

	/**
	 * Sets the latency of the network on testing device. Network latency is simply defined as the time delay observed
	 * as data transmits from one point on the network to another point on the same network.
	 * 
	 * @param latency
	 *        - latency value in milliseconds.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws InvalidPasskeyException
	 */
	public void setNetworkLatency(int latency, long invocationPasskey) throws RemoteException, InvalidPasskeyException;

	/**
	 * Gets latency of the network on the testing device. Network latency is simply defined as the time delay observed
	 * as data transmits from one point on the network to another point on the same network.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return - latency value in milliseconds.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws InvalidPasskeyException
	 */
	public int getNetworkLatency(long invocationPasskey) throws RemoteException, InvalidPasskeyException;

	/**
	 * Sets the level of the battery.
	 * 
	 * @param level
	 *        - the level of battery in percent.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public void setBatteryLevel(int level, long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Gets battery level of the testing device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return int - battery level percentage.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public int getBatteryLevel(long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Sets the battery state.
	 * 
	 * @param state
	 *        - a {@link BatteryState BatteryState} enum value.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws InvalidPasskeyException
	 */
	public void setBatteryState(BatteryState state, long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Gets battery state of testing device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return {@link BatteryState BatteryState} enum value.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public BatteryState getBatteryState(long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Gets the power state of the testing device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return True if connected, false otherwise.
	 * @throws CommandFailedException
	 * @throws RemoteException
	 * @throws InvalidPasskeyException
	 */
	public boolean getPowerState(long invocationPasskey)
		throws RemoteException,
			CommandFailedException,
			InvalidPasskeyException;

	/**
	 * Sets the power state of the testing device.
	 * 
	 * @param state
	 *        - True if connected, false otherwise.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws CommandFailedException
	 * @throws RemoteException
	 * @throws InvalidPasskeyException
	 */
	public void setPowerState(boolean state, long invocationPasskey)
		throws CommandFailedException,
			RemoteException,
			InvalidPasskeyException;

	/**
	 * Sets the airplane mode of the testing device.
	 * 
	 * @param airplaneMode
	 *        - True if in airplane mode, false otherwise.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws CommandFailedException
	 * @throws RemoteException
	 * @throws InvalidPasskeyException
	 */
	public void setAirplaneMode(boolean airplaneMode, long invocationPasskey)
		throws CommandFailedException,
			RemoteException,
			InvalidPasskeyException;

	/**
	 * Gets the container with information for the testing device.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return a {@link DeviceInformation DeviceInformation} structure containing information about the current device.
	 * @throws RemoteException
	 * @throws InvalidPasskeyException
	 */
	public DeviceInformation getDeviceInformation(long invocationPasskey)
		throws RemoteException,
			InvalidPasskeyException;

	/**
	 * Sets new orientation of the testing device. Can only be applied on emulators.
	 * 
	 * @param deviceOrientation
	 *        - a @link {@link DeviceOrientation DeviceOrientation} object that describes the new device orientation to
	 *        be set.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public void setDeviceOrientation(DeviceOrientation deviceOrientation, long invocationPasskey)
		throws CommandFailedException,
			RemoteException,
			InvalidPasskeyException;

	/**
	 * Gets the device orientation of the device. The orientation sensor on the device must be active.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return a DeviceOrientation instance.
	 * @throws InvalidPasskeyException
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public DeviceOrientation getDeviceOrientation(long invocationPasskey)
		throws InvalidPasskeyException,
			CommandFailedException,
			RemoteException;

	/**
	 * Sets new screen orientation of the device.
	 * 
	 * @param screenOrientation
	 *        - a @link {@link ScreenOrientation ScreenOrientation} enum element that describes the screen orientation
	 *        to be set.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 * @throws InvalidPasskeyException
	 */
	public void setScreenOrientation(ScreenOrientation screenOrientation, long invocationPasskey)
		throws RemoteException,
			InvalidPasskeyException;

	/**
	 * Control whether the accelerometer will be used to change screen orientation
	 * 
	 * @param autoRotation
	 *        - if false, it will not be used unless explicitly requested by the application; if true, it will be used
	 *        by default unless explicitly disabled by the application.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 * @throws InvalidPasskeyException
	 */
	public void setAutoRotation(boolean autoRotation, long invocationPasskey)
		throws RemoteException,
			InvalidPasskeyException;

	/**
	 * Sets new acceleration for the testing device. Can only be applied on emulators.
	 * 
	 * @param deviceAcceleration
	 *        - a @link {@link DeviceAcceleration DeviceAcceleration} object that describes the new device acceleration
	 *        to be set.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 * @throws InvalidPasskeyException
	 */
	public void setAcceleration(DeviceAcceleration deviceAcceleration, long invocationPasskey)
		throws CommandFailedException,
			RemoteException,
			InvalidPasskeyException;

	/**
	 * Gets the device acceleration of the device. The accelerometer on the device must be active.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return a DeviceAcceleration instance.
	 * @throws InvalidPasskeyException
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public DeviceAcceleration getDeviceAcceleration(long invocationPasskey)
		throws InvalidPasskeyException,
			CommandFailedException,
			RemoteException;

	/**
	 * Sets the mobile data state of an emuslator.
	 * 
	 * @param state
	 *        - a member of the {@link MobileDataState} enum.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @throws InvalidPasskeyException
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public void setMobileDataState(MobileDataState state, long invocationPasskey)
		throws InvalidPasskeyException,
			CommandFailedException,
			RemoteException;

	/**
	 * Gets the mobile data state of an emulator.
	 * 
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * @return a member of the {@link MobileDataState} enum.
	 * @throws InvalidPasskeyException
	 * @throws RemoteException
	 */
	public ConnectionType getConnectionType(long invocationPasskey)
		throws InvalidPasskeyException,
			CommandFailedException,
			RemoteException;

	/**
	 * Gets the mobile data state of an emulator.
	 * 
	 * @param state
	 *        - a member of the {@link MobileDataState} enum.
	 * @param invocationPasskey
	 *        - the authorization passkey that validates this invocation is coming from a legitimate source.
	 * 
	 * @throws InvalidPasskeyException
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public MobileDataState getMobileDataState(long invocationPasskey)
		throws InvalidPasskeyException,
			CommandFailedException,
			RemoteException;
}
