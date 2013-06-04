package com.musala.atmosphere.commons.cs.clientbuilder;

/**
 * Enumeration with all possible choices for requesting physical presence of device - <i>EMULATOR_ONLY</i>,
 * <i>DEVICE_ONLY</i>, <i>EMULATOR_PREFERRED</i>, <i>DEVICE_PREFERRED</i> or <i>NO_PREFERENCE</i>.
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum DeviceType
{
	/**
	 * <i><b>EMULATOR_ONLY</b></i>
	 */
	EMULATOR_ONLY("emulator_only"),

	/**
	 * <i><b>DEVICE_ONLY</b></i>
	 */
	DEVICE_ONLY("device_only"),

	/**
	 * <i><b>EMULATOR_PREFERRED</b></i>
	 */
	EMULATOR_PREFERRED("emulator_preferred"),

	/**
	 * <i><b>DEVICE_PREFERRED</b></i>
	 */
	DEVICE_PREFERRED("device_preferred"),

	/**
	 * <i><b>NO_PREFERENCE</b></i>
	 */
	NO_PREFERENCE("no_preference");

	private String value;

	private DeviceType(String deviceType)
	{
		this.value = deviceType;
	}

	@Override
	public String toString()
	{
		return value;
	}

}
