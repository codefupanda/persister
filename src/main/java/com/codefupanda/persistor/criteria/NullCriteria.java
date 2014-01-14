package com.codefupanda.persistor.criteria;

/**
 * Check for null
 * @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class NullCriteria implements Criteria{
	private String property;
	private boolean isNull;
	
	/**
	 * @param criteria
	 * @param isNull
	 */
	NullCriteria(String property, boolean isNull) {
		super();
		this.property = property;
		this.isNull = isNull;
	}
	
	/**
	 * @return the criteria
	 */
	public String getProperty() {
		return property;
	}
	
	/**
	 * @return the isNull
	 */
	public boolean isNull() {
		return isNull;
	}
}
