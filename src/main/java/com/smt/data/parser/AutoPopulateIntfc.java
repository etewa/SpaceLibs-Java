package com.smt.data.parser;

import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

/****************************************************************************
 * <b>Title:</b> AutoPopulateIntfc.java
 * <b>Project:</b> SMTBaseLibs
 * <b>Description:</b> Convert the BeanDataVO member methods to be interface
 * driven to support better usage.
 * <b>Copyright:</b> Copyright (c) 2019
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Billy Larsen
 * @version 3.3.1
 * @since Mar 26, 2019
 ****************************************************************************/
public interface AutoPopulateIntfc {

	/**
	 * Maps the incoming request object into the bean data's member variables.
	 * In order for this to work, the request parameter name must match the 
	 * name of the member variable.  For example, for the member variable 
	 * "private String firstName = null;" the request parameter must must be
	 * set to "firstName"
	 * @param req SMTServletRequest object
	 */
	public default void populateData(HttpServletRequest req) {
		BeanDataMapper.parseBean(this, req.getParameterMap());
	}

	/**
	 * 
	 * @param req Http Servlet Request Object
	 * @param suffix - Some fields have a suffix for uniqueness.  This strips and maps
	 */
	public default void populateData(HttpServletRequest req, String suffix) {
		BeanDataMapper.parseBean(this, req.getParameterMap(), suffix);
	}

	/**
	 * Maps the result set row (this method is careful to not increment the result set
	 * counter) into the appropriate member variable.  This is accomplished using the
	 * @Table and @Column Annotations in the base libs
	 * @param rs Single row of the result set
	 */
	public default void populateData(ResultSet rs) {
		// new DBProcessor(null).executePopulate(this, rs, null);
	}
}
