package com.musala.atmosphere.commons.cs.clientbuilder;

/**
 * This enumeration contains all possible values for devices' OS. For now there are only three options:
 * <i>JELLY_BEAN</i> ( Android 4.1 ), <i>JELLY_BEAN_MR1</i> ( Android 4.2 ) and <i>NO_PREFERENCE</i> ( OS by default ).
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum DeviceOs
{
	/**
	 * <i><b>Android 4.1</b></i>
	 */
	JELLY_BEAN_4_1("4.1"),

	/**
	 * <i><b>Android 4.2.1</b></i>
	 */
	JELLY_BEAN_MR1_4_2_1("4.2.1"),

	/**
	 * <i><b>Android 4.2.2</b></i>
	 */
	JELLY_BEAN_MR1_4_2_2("4.2.2"),

	/**
	 * It means <i>"any available OS"</i>. OS by default when constructing new device.
	 */
	NO_PREFERENCE("no_preference");

	private String value;

	private DeviceOs(String deviceOs)
	{
		this.value = deviceOs;
	}

	@Override
	public String toString()
	{
		return value;
	}

}
