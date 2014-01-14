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
package com.codefupanda.persistor.dialect;

import java.sql.Types;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Extends Hibernate Mysql Dialect and register bigint type
 * Usage 
 * <code>
 * 	<property name="hibernate.dialect">com.codefupanda.persistor.dialect.MySqlDialect</property>
 * </code>
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class MySqlDialect extends MySQL5Dialect {
	
	/**
	 * register bigint type
	 */
	public MySqlDialect() {
		registerColumnType(Types.NUMERIC, "bigint");
	}
}
