/*
 * MODIFIED DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * Version 1, August 2012
 *               Based on WTFPL version 2
 *
 * Original WTFPL Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 * 
 * Copyright (C) 2013 Shashank <shashank.physics at gmail.com>
 *  
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed
 *
 * MODIFIED DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 * 
 * 0. Give credit to the authors and contributors
 * 1. You are free to do whatever the fuck you want to with the source as long as you do not violate terms 0.
 */
package com.codefupanda.persistor.util;


import org.springframework.data.mongodb.core.query.Query;

import com.codefupanda.persistor.criteria.BetweenCriteria;
import com.codefupanda.persistor.criteria.Criteria;
import com.codefupanda.persistor.criteria.LogicalCriteria;
import com.codefupanda.persistor.criteria.NullCriteria;
import com.codefupanda.persistor.criteria.PropertyValueExpressionCriteria;
import com.codefupanda.persistor.criteria.SearchCriteria;

/**
 * Helper methods for working with Spring Mongo API
 * 
 * @author Shashank Kulkarni
 */
public class SpringMongoUtil {
	
	/**
	 * Convert {@link SearchCriteria} to Spring MongoDB Query
	 * @param searchCriteria
	 * @return
	 */
	public static Query convert(SearchCriteria searchCriteria) {
		Query query = new Query();
		
		for(Criteria criteria : searchCriteria.getCriterias()) {
			query.addCriteria(convert(criteria));
		}
		
		return query;
	}

	/**
	 * @param criteria
	 * @return
	 */
	private static org.springframework.data.mongodb.core.query.Criteria convert(
			Criteria criteria) {
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

	/**
	 * @param criteria
	 * @return
	 */
	@SuppressWarnings("static-access")
	private static org.springframework.data.mongodb.core.query.Criteria convert(
			PropertyValueExpressionCriteria criteria) {
		org.springframework.data.mongodb.core.query.Criteria result = new org.springframework.data.mongodb.core.query.Criteria();
		if(criteria.getOp().equals("=")) {
			result = result.where(criteria.getProperty()).is(criteria.getValue());
		} else if(criteria.getOp().equals(">")) {
			result = result.where(criteria.getProperty()).gt(criteria.getValue());
		} else if(criteria.getOp().equals("<")) {
			result = result.where(criteria.getProperty()).lt(criteria.getValue());
		} else if(criteria.getOp().equals(">=")) {
			result = result.where(criteria.getProperty()).gte(criteria.getValue());
		} else if(criteria.getOp().equals("<=")) {
			result = result.where(criteria.getProperty()).lte(criteria.getValue());
		} else if(criteria.getOp().equals("in")) {
			result = result.where(criteria.getProperty()).in(criteria.getValue());
		} else if(criteria.getOp().equals("like")) {
			result = result.where(criteria.getProperty()).regex((String)criteria.getValue());
		} else if(criteria.getOp().equals("ilike")) {
			result = result.where(criteria.getProperty()).regex((String)criteria.getValue(), "i");
		}
		return result;
	}
	
	private static org.springframework.data.mongodb.core.query.Criteria convert(
			LogicalCriteria criteria) {
		org.springframework.data.mongodb.core.query.Criteria result = new org.springframework.data.mongodb.core.query.Criteria();
		org.springframework.data.mongodb.core.query.Criteria[] temp = {
					convert(criteria.getLhs()),
					convert(criteria.getRhs())
				};
		
		if(criteria.getLogicalOp().equals("or")) {
			result = result.orOperator(temp);
		} else if(criteria.getLogicalOp().equals("and")) {
			result = result.andOperator(temp);
		} 
		return result;
	}
	
	@SuppressWarnings("static-access")
	private static org.springframework.data.mongodb.core.query.Criteria convert(
			BetweenCriteria criteria) {
		org.springframework.data.mongodb.core.query.Criteria result = new org.springframework.data.mongodb.core.query.Criteria();
		result = result.andOperator(
					result.where(criteria.getProperty()).gte(criteria.getLoValue()), 
					result.where(criteria.getProperty()).lte(criteria.getLoValue())
				);
		return result;
	}
	
	@SuppressWarnings("static-access")
	private static org.springframework.data.mongodb.core.query.Criteria convert(
			NullCriteria criteria) {
		org.springframework.data.mongodb.core.query.Criteria result = new org.springframework.data.mongodb.core.query.Criteria();
		if(criteria.isNull()) {
			result = result.where(criteria.getProperty()).is(null);
		} else {
			result = result.where(criteria.getProperty()).ne(null);
		}
		return result;
	}
}
