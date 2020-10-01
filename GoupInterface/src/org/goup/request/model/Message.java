/**
 * This package contain the  class for GOUP Application to set Generic Responses for Calling  API
 */
package org.goup.request.model;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * This class work to to set Generic Responses for Calling API
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-07-30
 */
public class Message {
	/***
	 * Declaring Description ,object, list and valid bit
	 */
	private String description;
	private Object object;
	private List<Object> list;
	private boolean valid;

	/**
	 * To get the Message
	 * 
	 * @return String  description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * To set the Message
	 * 
	 * @param description
	 * 			String value represents description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * to get Object
	 * 
	 * @return Object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * To set Object
	 * 
	 * @param object
	 * 			Object that is to be set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * to get the List
	 * 
	 * @return List<Object>
	 */
	public List<Object> getList() {
		return list;
	}

	/**
	 * To set the list
	 * 
	 * @param list
	 * 			list of Objects
	 */
	public void setList(List<Object> list) {
		this.list = list;
	}

	/**
	 * To get If Message is Valid
	 * 
	 * @return Boolean
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * To set Result Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
