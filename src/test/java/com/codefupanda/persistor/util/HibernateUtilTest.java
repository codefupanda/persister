/*
* MODIFIED DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
* Version 1, August 2012
* Based on WTFPL version 2
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
package com.codefupanda.persistor.util;


import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;

import com.codefupanda.persistor.criteria.Filter;
import com.codefupanda.persistor.criteria.SearchCriteria;
import com.codefupanda.persistor.util.HibernateUtil;

/**
 * @author Shashank Kulkarni
 */
public class HibernateUtilTest {
	
	@Test
	public void convertTest() throws Throwable {
		SearchCriteria criteria = new SearchCriteria(HibernateUtilTest.class);
		
		criteria.add(Filter.eq("test", "test"));
		
		DetachedCriteria result = HibernateUtil.convert(criteria);
		System.out.println(result);
	}
}
