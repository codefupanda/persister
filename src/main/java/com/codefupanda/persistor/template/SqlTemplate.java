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

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.codefupanda.persistor.criteria.SearchCriteria;
import com.codefupanda.persistor.util.HibernateUtil;

/**
 * Prodives implementation for {@link Template} for SQL databases.
 * Wraps the {@link HibernateTemplate}
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class SqlTemplate implements Template{

	private HibernateTemplate template;
	
	/**
	 * Default constructor
	 * @param sessionFactory Hibernate Session Factory
	 */
	public SqlTemplate(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public <T> T find(Class<T> clasz, Serializable id) {
		return template.get(clasz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(SearchCriteria criteria) {
		DetachedCriteria hCriteria = HibernateUtil.convert(criteria);
		return template.findByCriteria(hCriteria);
	}

	@Override
	public Serializable save(Object entity) {
		return template.save(entity);
	}

	@Override
	public void delete(Object entity) {
		template.delete(entity);
	}

	@Override
	public <T> void deleteById(Class<T> clasz, Serializable id) {
		template.delete(find(clasz, id));
	}
	
}
