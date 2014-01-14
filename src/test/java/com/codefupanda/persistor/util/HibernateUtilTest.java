/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
