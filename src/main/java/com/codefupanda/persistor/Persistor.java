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
package com.codefupanda.persistor;


import java.io.Serializable;
import java.util.List;

import com.codefupanda.persistor.criteria.SearchCriteria;

/**
 * Common Persistor. Provides generic methods for persistence 
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public interface Persistor {
	
	<T> T find(Class<T> clasz, Serializable id);
	
	<T> List<T> find(SearchCriteria criteria);
	
	Serializable save(Object entity);
	
	void delete(Object entity);
	
	<T> void deleteById(Class<T> clasz, Serializable id);
}
