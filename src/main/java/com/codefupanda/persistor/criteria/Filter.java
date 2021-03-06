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

import java.util.Collection;


/**
 * Contains filters for adding to {@link SearchCriteria}
 * 
 *  @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class Filter {
	
	private Filter() {
		// private constructor
	}
	
	public static Criteria eq(String parameter, Object value) {
		return new PropertyValueExpressionCriteria(parameter, value, "=");
	}
	
	public static Criteria gt(String parameter, Object value) {
		return new PropertyValueExpressionCriteria(parameter, value, ">");
	}
	
	public static Criteria ls(String parameter, Object value) {
		return new PropertyValueExpressionCriteria(parameter, value, "<");
	}
	
	public static Criteria ge(String parameter, Object value) {
		return new PropertyValueExpressionCriteria(parameter, value, ">=");
	}
	
	public static Criteria le(String parameter, Object value) {
		return new PropertyValueExpressionCriteria(parameter, value, "<=");
	}
	
	public static Criteria in(String parameter, Object[] values) {
		return new PropertyValueExpressionCriteria(parameter, values, "in");
	}
	
	public static Criteria in(String parameter, Collection<?> values) {
		return new PropertyValueExpressionCriteria(parameter, values.toArray(), "in");
	}
	 
	public static Criteria or(Criteria lhs, Criteria rhs) {
		return new LogicalCriteria(lhs, rhs, "or");
	}
	
	public static Criteria and(Criteria lhs, Criteria rhs) {
		return new LogicalCriteria(lhs, rhs, "and");
	}
	
	public static Criteria between(String property, Object loValue, Object hiValue) {
		return new BetweenCriteria(property, loValue, hiValue);
	}
	
	public static Criteria like(String property, Object pattern) {
		return new PropertyValueExpressionCriteria(property, pattern, "like");
	}
	
	public static Criteria iLike(String property, Object pattern) {
		return new PropertyValueExpressionCriteria(property, pattern, "ilike");
	}
	
	public static Criteria not(Criteria criteria) {
		return new LogicalNotCriteria(criteria);
	}
	
	public static Criteria isNull(String property) {
		return new NullCriteria(property, true);
	}
	
	public static Criteria isNotNull(String property) {
		return new NullCriteria(property,  false);
	}
}
