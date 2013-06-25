package com.musala.atmosphere.commons.cs.clientbuilder;

import java.io.Serializable;

/**
 * Holds the parameters, needed to construct new device. If the current parameter is not needed it is set by default to
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
	 * Constructor that sets all properties to their default (no preference) values.
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
	 * Returns the set wanted device type.
	 * 
	 * @return - {@link DeviceType DeviceType}
	 */
	public DeviceType getDeviceType()
	{
		return deviceType;
	}

	/**
	 * Sets the wanted device type - emulator, real device or no preference.
	 * 
	 * @param deviceType
	 *        - {@link DeviceType DeviceType}
	 */
	public void setDeviceType(DeviceType deviceType)
	{
		this.deviceType = deviceType;
	}

	/**
	 * Returns the set wanted OS on the testing device.
	 * 
	 * @return - {@link DeviceOs DeviceOs}
	 */
	public DeviceOs getOs()
	{
		return deviceOs;
	}

	/**
	 * Sets the wanted OS of the testing device.
	 * 
	 * @param os
	 *        - {@link DeviceOs DeviceOs}
	 */
	public void setOs(DeviceOs os)
	{
		this.deviceOs = os;
	}

	/**
	 * Returns the set wanted <i>height</i> of the testing device screen resolution.
	 * 
	 * @return the screen resolution height.
	 */
	public int getResolutionHeight()
	{
		return resolutionHeight;
	}

	/**
	 * Sets the wanted screen resolution height.
	 * 
	 * @param resolutionHeight
	 *        the wanted screen resolution height.
	 */
	public void setResolutionHeight(int resolutionHeight)
	{
		this.resolutionHeight = resolutionHeight;
	}

	/**
	 * Returns the set wanted <i>width</i> of the testing device screen resolution.
	 * 
	 * @return the resolution width
	 */
	public int getResolutionWidth()
	{
		return resolutionWidth;
	}

	/**
	 * Sets the wanted screen resolution width.
	 * 
	 * @param resolutionWidth
	 *        - the wanted screen resolution width.
	 */
	public void setResolutionWidth(int resolutionWidth)
	{
		this.resolutionWidth = resolutionWidth;
	}

	/**
	 * Returns the set wanted <i>dpi</i> of the testing device's screen.
	 * 
	 * @return the screen dpi.
	 */
	public int getDpi()
	{
		return dpi;
	}

	/**
	 * Sets the wanted screen dpi of the testing device.
	 * 
	 * @param dpi
	 *        the wanted screen dpi.
	 */
	public void setDpi(int dpi)
	{
		this.dpi = dpi;
	}

	/**
	 * Returns the set wanted <i>RAM</i> of the testing device.
	 * 
	 * @return the set wanted ram.
	 */
	public int getRam()
	{
		return ram;
	}

	/**
	 * Sets the wanted RAM amount of the testing device.
	 * 
	 * @param ram
	 *        the wanted device ram amount.
	 */
	public void setRam(int ram)
	{
		this.ram = ram;
	}

}
