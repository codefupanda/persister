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
package com.codefupanda.persistor.util;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.codefupanda.persistor.criteria.BetweenCriteria;
import com.codefupanda.persistor.criteria.Criteria;
import com.codefupanda.persistor.criteria.LogicalCriteria;
import com.codefupanda.persistor.criteria.NullCriteria;
import com.codefupanda.persistor.criteria.PropertyValueExpressionCriteria;
import com.codefupanda.persistor.criteria.SearchCriteria;

/**
 * Some Hibernate helper methods
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class HibernateUtil {
	
	/**
	 * Convert the API specific criteria to Hibernate DerachedCriteria
	 * 
	 * @param searchCriteria
	 * @return
	 */
	public static DetachedCriteria convert(SearchCriteria searchCriteria) {
		DetachedCriteria hCriteria = DetachedCriteria.forClass(searchCriteria.getSearchClass());
		
		for(Criteria criteria : searchCriteria.getCriterias()) {
			hCriteria.add(convert(criteria));
		}
		return hCriteria;
	}

	/**
	 * @param criteria
	 * @return
	 */
	private static Criterion convert(Criteria criteria) {
		if(criteria instanceof  PropertyValueExpressionCriteria) {
			return convert((PropertyValueExpressionCriteria) criteria);
		} else if(criteria instanceof  LogicalCriteria) {
			return convert((LogicalCriteria) criteria);
		} else if(criteria instanceof  BetweenCriteria) {
			return convert((BetweenCriteria) criteria);
		} else if(criteria instanceof  NullCriteria) {
			return convert((NullCriteria) criteria);
		} 
		return null;
	}
	
	private static Criterion convert(PropertyValueExpressionCriteria criteria) {
		Criterion criterion = null;
		String property = criteria.getProperty();
		Object value = criteria.getValue();
		
		if(criteria.getOp().equals("=")) {
			criterion = Restrictions.eq(property, value);
		} else if(criteria.getOp().equals(">")) {
			criterion = Restrictions.gt(property, value);
		} else if(criteria.getOp().equals("<")) {
			criterion = Restrictions.lt(property, value);
		} else if(criteria.getOp().equals(">=")) {
			criterion = Restrictions.ge(property, value);
		} else if(criteria.getOp().equals("<=")) {
			criterion = Restrictions.le(property, value);
		} else if(criteria.getOp().equals("in")) {
			criterion = Restrictions.in(property, (Object[])value);
		} else if(criteria.getOp().equals("like")) {
			criterion = Restrictions.like(property, value);
		} else if(criteria.getOp().equals("ilike")) {
			criterion = Restrictions.ilike(property, value);
		}
		return criterion;
	}
	
	private static Criterion convert(LogicalCriteria criteria) {
		Criterion criterion = null;
		Criteria lhs = criteria.getLhs();
		Criteria rhs = criteria.getRhs();
		
		if(criteria.getLogicalOp().equals("or")) {
			criterion = Restrictions.or(convert(lhs), convert(rhs));
		} else if(criteria.getLogicalOp().equals("and")) {
			criterion = Restrictions.and(convert(lhs), convert(rhs));
		} 
		return criterion;
	}
	
	private static Criterion convert(BetweenCriteria criteria) {
		return Restrictions
				.between(criteria.getProperty(), criteria.getLoValue(), criteria.getHiValue());
	}
	
	private static Criterion convert(NullCriteria criteria) {
		if(criteria.isNull()) {
			return Restrictions.isNull(criteria.getProperty());
		} 
		return Restrictions.isNotNull(criteria.getProperty());
	}
	
}
