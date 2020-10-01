/**
 * This package contains classes to get Parameters for Calling API as Map, to use reflection while particular interface API calling.
 */
package org.goup.constant;

import java.lang.reflect.InvocationTargetException;
/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Method;

/**
 * This class is used to consume reflection API methods to process request on any interface.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-07-30
 */
public class Constant {
	
	// private constructor
	private Constant () {
		
	}
	
	/**
	 * This method invokes service implementation for an interface to process incoming request.
	 * 
	 * @param className
	 * 			String value represents name of interface class
	 * @param methodName
	 * 			String value represents name of interface service method
	 * @param paramType
	 * 			Array of parameter types
	 * @param paramValue
	 * 			Array of parameter values
	 * @return	returns object of interface
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws Exception  
	 * 			throws exception instance when method execution fails
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object executeMethods(String className, String methodName, Class[] paramType, Object[] paramValue) throws InstantiationException, IllegalAccessException,  InvocationTargetException, ClassNotFoundException,  NoSuchMethodException
			 {

		Class interfaceClass = Class.forName(className);

		Object object = interfaceClass.newInstance();

		Method method = interfaceClass.getMethod(methodName, paramType);

		return method.invoke(object, paramValue);
	}
	
}
