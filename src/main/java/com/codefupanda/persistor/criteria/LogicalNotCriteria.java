/**
 * 
 */
package com.codefupanda.persistor.criteria;

/**
 * Not operator
 * 
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class LogicalNotCriteria implements Criteria {
	private Criteria criteria;

	/**
	 * @param criteria
	 */
	LogicalNotCriteria(Criteria criteria) {
		super();
		this.criteria = criteria;
	}

	/**
	 * @return the criteria
	 */
	public Criteria getCriteria() {
		return criteria;
	}
	
}
