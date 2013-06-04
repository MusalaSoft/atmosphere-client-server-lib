package com.musala.atmosphere.commons.cs.clientbuilder;

import java.io.Serializable;

/**
 * Holds the parameters, needed to construct new device. If the current parameter is no needed it is set by default to
 * "No preference".
 * 
 * @author vladimir.vladimirov
 * 
 */

public class DeviceParameters implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2882881882742875572L;

	/**
	 * Default values for device properties.
	 */

	public static final DeviceType DEVICE_TYPE_NO_PREFERENCE = DeviceType.NO_PREFERENCE;

	public static final DeviceOs DEVICE_OS_NO_PREFERENCE = DeviceOs.NO_PREFERENCE;

	public static final int RESOLUTION_HEIGHT_NO_PREFERENCE = -1;

	public static final int RESOLUTION_WIDTH_NO_PREFERENCE = -1;

	public static final int DPI_NO_PREFERENCE = -1;

	public static final int RAM_NO_PREFERENCE = -1;

	/**
	 * DeviceParameters data members.
	 */
	private DeviceType deviceType;

	private DeviceOs deviceOs;

	private int resolutionHeight;

	private int resolutionWidth;

	private int dpi;

	private int ram;

	/**
	 * Constructor by default.
	 */
	public DeviceParameters()
	{
		deviceType = DEVICE_TYPE_NO_PREFERENCE;
		deviceOs = DEVICE_OS_NO_PREFERENCE;
		resolutionHeight = RESOLUTION_HEIGHT_NO_PREFERENCE;
		resolutionWidth = RESOLUTION_WIDTH_NO_PREFERENCE;
		dpi = DPI_NO_PREFERENCE;
		ram = RAM_NO_PREFERENCE;
	}

	/**
	 * Gets the type of device.
	 * 
	 * @return - {@link EmulatorSelectionOptions EmulatorSelectionOptions }
	 */
	public DeviceType getDeviceType()
	{
		return deviceType;
	}

	/**
	 * Sets the device type - emulator, real device or no preference.
	 * 
	 * @param emulator
	 *        - {@link EmulatorSelectionOptions EmulatorSelectionOptions }
	 */
	public void setDeviceType(DeviceType deviceType)
	{
		this.deviceType = deviceType;
	}

	/**
	 * Return the type of OS on the testing device.
	 * 
	 * @return - {@link DeviceOs DeviceOs}
	 */
	public DeviceOs getOs()
	{
		return deviceOs;
	}

	/**
	 * Sets the OS of the testing device.
	 * 
	 * @param os
	 *        - {@link DeviceOs DeviceOs}
	 */
	public void setOs(DeviceOs os)
	{
		this.deviceOs = os;
	}

	/**
	 * Return the <i>height</i> of the testing device resolution.
	 * 
	 * @return the resolution height
	 */
	public int getResolutionHeight()
	{
		return resolutionHeight;
	}

	/**
	 * Sets the resolution height.
	 * 
	 * @param resolutionHeight
	 *        the resolution height to set
	 */
	public void setResolutionHeight(int resolutionHeight)
	{
		this.resolutionHeight = resolutionHeight;
	}

	/**
	 * Return the <i>width</i> of the testing device resolution.
	 * 
	 * @return the resolution width
	 */
	public int getResolutionWidth()
	{
		return resolutionWidth;
	}

	/**
	 * Sets the resolution width.
	 * 
	 * @param resolutionWidth
	 *        - the resolution width to set
	 */
	public void setResolutionWidth(int resolutionWidth)
	{
		this.resolutionWidth = resolutionWidth;
	}

	/**
	 * Return the <i>dpi</i> of the testing device's screen.
	 * 
	 * @return the dpi
	 */
	public int getDpi()
	{
		return dpi;
	}

	/**
	 * Sets the screen dpi of the testing device.
	 * 
	 * @param dpi
	 *        the dpi to set
	 */
	public void setDpi(int dpi)
	{
		this.dpi = dpi;
	}

	/**
	 * Return the <i>RAM</i> of the testing device.
	 * 
	 * @return the ram
	 */
	public int getRam()
	{
		return ram;
	}

	/**
	 * Sets the RAM of the testing device.
	 * 
	 * @param ram
	 *        the ram to set
	 */
	public void setRam(int ram)
	{
		this.ram = ram;
	}

}
