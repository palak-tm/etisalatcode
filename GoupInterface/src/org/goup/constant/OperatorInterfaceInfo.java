/**
 * This package contains classes to get Parameters for Calling API as Map, to use reflection while particular interface API calling.
 */
package org.goup.constant;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * This class is used for constant defined in dispatcher servlet having interface details.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-07-30
 */
@Component
public class OperatorInterfaceInfo {
	
	/**
	 * Parameter to Store Map
	 */
	private Map<String, Object> maps;

	/**
	 * To get parameters as Map
	 * 
	 * @return maps
	 */
	public Map<String, Object> getMaps() {
		return maps;
	}

	/**
	 * To set parameters in Map
	 * 
	 * @param maps
	 */
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

}
