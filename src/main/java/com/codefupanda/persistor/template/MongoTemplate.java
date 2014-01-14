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
package com.codefupanda.persistor.template;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.codefupanda.persistor.criteria.SearchCriteria;
import com.codefupanda.persistor.util.SpringMongoUtil;

/**
 * Provides {@link Template} implementation for MongoDB
 * Wraps {@link MongoTemplate}
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class MongoTemplate implements Template{

	private org.springframework.data.mongodb.core.MongoTemplate template;
	
	/**
	 * Default Constructor
	 */
	public MongoTemplate(org.springframework.data.mongodb.core.MongoTemplate template) {
		this.template = template;
	}
	
	@Override
	public <T> T find(Class<T> clasz, Serializable id) {
		return template.findOne(new Query(Criteria.where("_id").is(id)), clasz);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List find(SearchCriteria criteria) {
		Query sCriteria = SpringMongoUtil.convert(criteria);
		return (List) template.find(sCriteria, criteria.getSearchClass());
	}
	
	@Override
	public Serializable save(Object entity) {
		template.save(entity);
		return null;
	}

	@Override
	public void delete(Object entity) {
		template.remove(entity);
	}

	@Override
	public <T> void deleteById(Class<T> clasz, Serializable id) {
		template.remove(new Query(Criteria.where("_id").is(id)), clasz);
	}

}
