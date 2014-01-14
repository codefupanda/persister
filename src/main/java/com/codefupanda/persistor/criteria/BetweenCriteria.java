/*
 * MODIFIED DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * Version 1, August 2012
 *               Based on WTFPL version 2
 *
 * Original WTFPL Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 * Copyright (C) 2012 ron975
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 * 0. The source code of all derivative works must be available to the public
 * 1. The source code of all derivative works must be available under this license
 * 2. You are free to do whatever the fuck you want to with the source as long as you do not violate terms 0. and 1.
 */
package com.codefupanda.persistor.criteria;

/**
 * Between criteria
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class BetweenCriteria implements Criteria {
	private String property;
	private Object loValue;
	private Object hiValue;
	
	/**
	 * @param property property to apply condition
	 * @param lo low value
	 * @param hi high value
	 */
	BetweenCriteria(String property, Object loValue, Object hiValue) {
		super();
		this.property = property;
		this.loValue= loValue;
		this.hiValue = hiValue;
	}

	public String getProperty() {
		return property;
	}

	public Object getLoValue() {
		return loValue;
	}

	public Object getHiValue() {
		return hiValue;
	}
	
}
