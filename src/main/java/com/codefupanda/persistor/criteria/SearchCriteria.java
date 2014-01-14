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

import java.util.ArrayList;
import java.util.List;

/**
 * Create a Search Criteria with {@link Criteria}s 
 * for retrieving data from DB
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class SearchCriteria {
	
	private Class<?> searchClass;
	private List<Order> orders = new ArrayList<Order>();
	private List<Criteria> criterias = new ArrayList<Criteria>();
	
	/**
	 * Create a SearchCriteria for a class
	 * @param searchClass 
	 */
	public SearchCriteria(Class<?> searchClass) {
		this.searchClass = searchClass;
	}
	
	/**
	 * add Order
	 * @param order
	 */
	public void add(Order order) {
		orders.add(order);
	}
	
	/**
	 * Add criteria 
	 * @param criteria
	 */
	public void add(Criteria criteria) {
		criterias.add(criteria);
	}
	
	/**
	 * Get class for which the SearchCriteria is created 
	 * @return class to search the data for
	 */
	public Class<?> getSearchClass() {
		return searchClass;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public List<Criteria> getCriterias() {
		return criterias;
	}
}
