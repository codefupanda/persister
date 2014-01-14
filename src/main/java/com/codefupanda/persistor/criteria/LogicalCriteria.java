package com.codefupanda.persistor.criteria;

/**
 * Logical Criterias to be added to DB query
 *  @author Shashank Kulkarni (shashank.physics (@) gmail.com)
 */
public class LogicalCriteria implements Criteria {
	private Criteria lhs;
	private Criteria rhs;
	private String logicalOp;
	
	/**
	 * @param lhs
	 * @param rhs
	 * @param logicalOp
	 */
	LogicalCriteria(Criteria lhs, Criteria rhs, String logicalOp) {
		super();
		this.lhs = lhs;
		this.rhs = rhs;
		this.logicalOp = logicalOp;
	}

	public Criteria getLhs() {
		return lhs;
	}

	public Criteria getRhs() {
		return rhs;
	}

	public String getLogicalOp() {
		return logicalOp;
	}
}
