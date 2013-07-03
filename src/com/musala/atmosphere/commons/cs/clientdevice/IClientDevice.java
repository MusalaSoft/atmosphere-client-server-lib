package com.musala.atmosphere.commons.cs.clientdevice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.musala.atmosphere.commons.BatteryState;
import com.musala.atmosphere.commons.CommandFailedException;
import com.musala.atmosphere.commons.Pair;

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
	 * @return int - usable RAM on testing device in MB
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public int getFreeRam() throws RemoteException;

	/**
	 * Sends shell-command formated instruction to the Server for execution on testing device.
	 * 
	 * @param shellCommand
	 *        Executable shell command as a String.
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * 
	 */
	public String executeShellCommand(String shellCommand) throws RemoteException, CommandFailedException;

	/**
	 * Sends sequence of shell commands to be executed on the testing device.
	 * 
	 * @param commands
	 *        - List of the commands to be executed
	 * @return
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 */
	public List<String> executeSequenceOfShellCommands(List<String> commands)
		throws RemoteException,
			CommandFailedException;

	/**
	 * Prepares the testing device for future installation of the tested application.
	 * 
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws IOException
	 */
	public void initApkInstall() throws RemoteException, IOException;

	/**
	 * Receives packet of bytes from the testing application's installation file and appends them to the .apk on the
	 * testing device's side.
	 * 
	 * @param bytes
	 *        - next portion of bytes of the apk file to be transported to the device
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws IOException
	 */
	public void appendToApk(byte[] bytes) throws RemoteException, IOException;

	/**
	 * Gets together all pieces of byte packages in one .apk file and installs it to the current device.
	 * 
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 * @throws IOException
	 */
	public void buildAndInstallApk() throws RemoteException, IOException, CommandFailedException;

	/**
	 * Removes all traces from installation file from the testing device.
	 * 
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws IOException
	 */
	public void discardApk() throws RemoteException, IOException;

	/**
	 * Returns String, which holds all screen widget's properties.
	 * 
	 * @return XML of the screen's structure formated as a String
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 */
	public String getUiXml() throws RemoteException, CommandFailedException;

	/**
	 * Gets screenshot of testing device's screen.
	 * 
	 * @return - screenshot image as byte array
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 */
	public byte[] getScreenshot() throws RemoteException, CommandFailedException;

	/**
	 * Sets network upload and download speeds on device. Measure unit is KB.
	 * 
	 * @param speeds
	 *        - pair of type < uploadSpeed, downloadSpeed >
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public void setNetworkSpeed(Pair<Integer, Integer> speeds) throws RemoteException;

	/**
	 * Gets network speed of testing device as a pair of Integers. Measure unit is KB.
	 * 
	 * @return - pair of type < uploadSpeed, downloadSpeed >
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public Pair<Integer, Integer> getNetworkSpeed() throws RemoteException;

	/**
	 * Sets the latency of the network on testing device. Network latency is simply defined as the time delay observed
	 * as data transmits from one point on the network to another point on the same network.
	 * 
	 * @param latency
	 *        - latency value in ms ( milliseconds )
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public void setNetworkLatency(int latency) throws RemoteException;

	/**
	 * Gets latency of the network on the testing device. Network latency is simply defined as the time delay observed
	 * as data transmits from one point on the network to another point on the same network.
	 * 
	 * @return - latency value in ms ( milliseconds )
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public int getNetworkLatency() throws RemoteException;

	/**
	 * Sets the level of the battery.
	 * 
	 * @param level
	 *        - the level of battery in %
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public void setBatteryLevel(int level) throws RemoteException;

	/**
	 * Gets battery level of the testing device.
	 * 
	 * @return int - percent of battery level in range [0;100]
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 * @throws CommandFailedException
	 */
	public int getBatteryLevel() throws RemoteException, CommandFailedException;

	/**
	 * Sets the battery state.
	 * 
	 * @param state
	 *        - charging, not charging, discharging, unknown or full
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public void setBatteryState(BatteryState state) throws RemoteException;

	/**
	 * Gets battery state of testing device.
	 * 
	 * @return {@link BatteryState BatteryState}
	 * @throws RemoteException
	 *         a RemoteException is thrown when the execution of a remotely called method fails for some reason - broken
	 *         connection, missing method or something else.
	 */
	public BatteryState getBatteryState() throws RemoteException;
}
