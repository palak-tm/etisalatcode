/**
 * This package contain the  modal classes for swagger documentation of GOUP Router apis
 */
package org.goup.swagger.response;

/**
 * Import classes to access their functionality 
 */
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is used as modal class for userRegistration api response
 * 
 * @author sanjay
 * @Modified aman
 * @version 1.0
 * @Since 2019-04-25
 *
 */
@ApiModel
public class GetSimAuditHistory {
	
	@ApiModelProperty(value="userSessionLogs")
	private List<userSessionLogs> userSessionLogs ;

	/**
	 * To get the userSessionLogs details
	 * 
	 * @return List<userSessionLogs> users
	 */
	
	public List<userSessionLogs> getUserSessionLogs() {
		return userSessionLogs;
	}
	
	/**
	 * To Set the userSessionLogs details
	 * 
	 * @param List<userSessionLogs> users
	 */

	public void setUserSessionLogs(List<userSessionLogs> userSessionLogs) {
		this.userSessionLogs = userSessionLogs;
	}

	/**
	 * To get the user details
	 * 
	 * @return List<UserRegister> users
	 */

	
	
	
	
	/**
	 * This class is used as User Register Details object in userRegistration api response
	 * 
	 * @author sanjay
	 * @version 1.0
	 * @Since 2019-04-25
	 *
	 */
	@ApiModel
	public static class userSessionLogs {
		@ApiModelProperty(value="size", example="0")
		private int size ;
		
		/**
		 * This vairable contains the list the session logs parameters.
		 * */
		
		@ApiModelProperty(value="sessionLogs")
		private List<sessionLogs> sessionLogs ;
		
		@ApiModelProperty(value="userIdentifier")
		private String userIdentifier;

	

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		/**
		 * To get the sessionLogs
		 * 
		 * @return lit of sessionLogs
		 */
		public List<sessionLogs> getSessionLogs() {
			return sessionLogs;
		}

		public void setSessionLogs(List<sessionLogs> sessionLogs) {
			this.sessionLogs = sessionLogs;
		}

		/**
		 * To get the userIdentifier
		 * 
		 * @return String userIdentifier
		 */
		public String getUserIdentifier() {
			return userIdentifier;
		}

		public void setUserIdentifier(String userIdentifier) {
			this.userIdentifier = userIdentifier;
		}
		
		
		@ApiModel
		public static class sessionLogs {
			
			public String iccid;
			public String imsi;
			public String msisdn;
			public String change;
			public String date;
			public String changeSource;
			public String triggeredBy;
			public String status;
			public String getIccid() {
				return iccid;
			}
			public void setIccid(String iccid) {
				this.iccid = iccid;
			}
			public String getImsi() {
				return imsi;
			}
			public void setImsi(String imsi) {
				this.imsi = imsi;
			}
			public String getMsisdn() {
				return msisdn;
			}
			public void setMsisdn(String msisdn) {
				this.msisdn = msisdn;
			}
			public String getChange() {
				return change;
			}
			public void setChange(String change) {
				this.change = change;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public String getChangeSource() {
				return changeSource;
			}
			public void setChangeSource(String changeSource) {
				this.changeSource = changeSource;
			}
			public String getTriggeredBy() {
				return triggeredBy;
			}
			public void setTriggeredBy(String triggeredBy) {
				this.triggeredBy = triggeredBy;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			
		
	}

		

}




	
}
