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
import java.util.Map;

import com.codefupanda.persistor.criteria.SearchCriteria;
import com.codefupanda.persistor.template.Template;

/**
 * Provides implementation for {@link Persistor} 
 * 
 * Can connect to multiple data sources.
 * Chooses the data source based on the class name. 
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class PersistorImpl implements Persistor {

	private Map<Class<?>, Template> templates;
	
	@Override
	public <T> T find(Class<T> clasz, Serializable id) {
		return templates.get(clasz).find(clasz, id);
	}

	@Override
	public <T> List<T> find(SearchCriteria criteria) {
		return templates.get(criteria.getSearchClass()).find(criteria);
	}

	@Override
	public Serializable save(Object entity) {
		return templates.get(entity.getClass()).save(entity);
	}

	@Override
	public void delete(Object entity) {
		templates.get(entity.getClass()).delete(entity);
	}

	@Override
	public <T> void deleteById(Class<T> clasz, Serializable id) {
		templates.get(clasz).deleteById(clasz, id);
	}
	
	public Map<Class<?>, Template> getTemplates() {
		return templates;
	}

	public void setTemplates(Map<Class<?>, Template> templates) {
		this.templates = templates;
	}
}
