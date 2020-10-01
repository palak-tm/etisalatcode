/**
 * This package contains classes to get Parameters for Calling API as Map, to use reflection while 
 * particular interface API calling and constants used in application. 
 */
package org.goup.constant;

/**
 * This class is used to defined constants as per platforms.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-30
 */
public class AsyncConstant {
	
	/**
	 * This class contains related to GConnect platform.
	 */
	public class GConnectAsyncConstant {
		
		// constants for sync apis
		public static final String ACTIVATE_SIM_API_GROUP = "activateSimNotification";
		public static final String DEACTIVATE_SIM_API_GROUP="deactivateSimNotification";
		public static final String REACTIVATE_SIM_API_GROUP="reactivateSimNotification";
		public static final String SUSPEND_SIM_API_GROUP="suspendSimNotification";
		public static final String PLATFORM = "GConnect";
		
		// private constructor
		private GConnectAsyncConstant () {
			
		}
		
	}


}
