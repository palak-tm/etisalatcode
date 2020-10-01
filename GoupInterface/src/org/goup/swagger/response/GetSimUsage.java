package org.goup.swagger.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class GetSimUsage {
	
	@ApiModelProperty(value="userData")
	private List<UserSimDetails> userData ;

	public List<UserSimDetails> getUserData() {
		return userData;
	}

	public void setUserData(List<UserSimDetails> userData) {
		this.userData = userData;
	}
	
	
	public static class RatingGroup{
		
		
	}

	public static class UserSimDetails{
		
		@ApiModelProperty(value="currentNetworkIsoCodes", example="")
		private String currentNetworkIsoCodes ;
		
		@ApiModelProperty(value="currentNetworkMccMnc", example="")
		private String currentNetworkMccMnc ;
		
		@ApiModelProperty(value="email", example="amangrwl30@gmail.com")
		private String email ;
		
		@ApiModelProperty(value="expirationDate", example="")
		private String expirationDate ;
		
		@ApiModelProperty(value="firstName", example="sachin")
		private String firstName ;
		
		@ApiModelProperty(value="iccid", example="8946270044400176972")
		private String iccid ;
		
		@ApiModelProperty(value="imsi", example="404441111111112")
		private String imsi ;
		
		@ApiModelProperty(value="lastName", example="nahars")
		private String lastName ;
		
		@ApiModelProperty(value="msisdn", example="46769802130")
		private String msisdn ;
		
		@ApiModelProperty(value="notificationUuid", example="6b842041c3a246ab964d6a21fb4d4a27")
		private String notificationUuid ;
		
		@ApiModelProperty(value="ratingGroup")
		private RatingGroup ratingGroup ;
		
		@ApiModelProperty(value="serverGroup", example="HP")
		private String serverGroup ;
		
		@ApiModelProperty(value="sessionStatusType", example="ACTIVE")
		private String sessionStatusType ;
		
		@ApiModelProperty(value="sessionTimestamp", example="2018-07-13 07:31:33")
		private String sessionTimestamp ;
		
		@ApiModelProperty(value="startVolume", example="0")
		private String startVolume ;
		
		@ApiModelProperty(value="stopped", example="false")
		private String stopped ;
		
		@ApiModelProperty(value="throttlingStartVolume", example="0")
		private String throttlingStartVolume ;
		
		@ApiModelProperty(value="throttlingVolume", example="0")
		private String throttlingVolume ;
		
		@ApiModelProperty(value="uid", example="client_28_type8543")
		private String uid ;
		
		@ApiModelProperty(value="userIdentifier", example="defaults2497fe237e7649a680b4af4a7a0e6cf8")
		private String userIdentifier ;
		
		@ApiModelProperty(value="volume", example="0")
		private String volume ;

		
		/**
		 * To get the currentNetworkIsoCodes
		 * 
		 * @return String currentNetworkIsoCodes
		 */
		public String getCurrentNetworkIsoCodes() {
			return currentNetworkIsoCodes;
		}

		/**
		 * To set the currentNetworkIsoCodes
		 * 
		 * @param currentNetworkIsoCodes
		 * 			String value represents currentNetworkIsoCodes
		 */
		
		public void setCurrentNetworkIsoCodes(String currentNetworkIsoCodes) {
			this.currentNetworkIsoCodes = currentNetworkIsoCodes;
		}

		/**
		 * To get the currentNetworkMccMnc
		 * 
		 * @return String currentNetworkMccMnc
		 */
		
		public String getCurrentNetworkMccMnc() {
			return currentNetworkMccMnc;
		}

		/**
		 * To set the currentNetworkMccMnc
		 * 
		 * @param currentNetworkMccMnc
		 * 			String value represents currentNetworkMccMnc
		 */
		
		public void setCurrentNetworkMccMnc(String currentNetworkMccMnc) {
			this.currentNetworkMccMnc = currentNetworkMccMnc;
		}
		
		/**
		 * To get the email
		 * 
		 * @return String email
		 */

		public String getEmail() {
			return email;
		}

		/**
		 * To set the email
		 * 
		 * @param email
		 * 			String value represents email
		 */
		
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * To get the expirationDate
		 * 
		 * @return String expirationDate
		 */
		public String getExpirationDate() {
			return expirationDate;
		}

		/**
		 * To set the expirationDate
		 * 
		 * @param expirationDate
		 * 			String value represents expirationDate
		 */
		
		public void setExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
		}

		/**
		 * To get the firstName
		 * 
		 * @return String firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * To set the firstName
		 * 
		 * @param firstName
		 * 			String value represents firstName
		 */
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		
		/**
		 * To get the iccid
		 * 
		 * @return String iccid
		 */
		public String getIccid() {
			return iccid;
		}

		/**
		 * To set the iccid
		 * 
		 * @param iccid
		 * 			String value represents iccid
		 */
		
		public void setIccid(String iccid) {
			this.iccid = iccid;
		}

		/**
		 * To get the imsi
		 * 
		 * @return String imsi
		 */
		public String getImsi() {
			return imsi;
		}

		/**
		 * To set the imsi details
		 * 
		 * @param imsi
		 * 			String value represents imsi
		 */
		
		public void setImsi(String imsi) {
			this.imsi = imsi;
		}

		/**
		 * To get the user details
		 * 
		 * @return String users
		 */
		public String getLastName() {
			return lastName;
		}

		
		/**
		 * To set the lastName details
		 * 
		 * @param lastName
		 * 			String value represents lastName
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
		/**
		 * To get the msisdn details
		 * 
		 * @return String msisdn
		 */

		public String getMsisdn() {
			return msisdn;
		}

		/**
		 * To set the msisdn details
		 * 
		 * @param msisdn
		 * 			String value represents msisdn
		 */
		
		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}
		
		/**
		 * To get the notificationUuid details
		 * 
		 * @return String notificationUuid
		 */

		public String getNotificationUuid() {
			return notificationUuid;
		}

		
		/**
		 * To set the notificationUuid
		 * 
		 * @param notificationUuid
		 * 			String value represents notificationUuid
		 */
		public void setNotificationUuid(String notificationUuid) {
			this.notificationUuid = notificationUuid;
		}

		/**
		 * To get the serverGroup
		 * 
		 * @return String serverGroup
		 */
		public String getServerGroup() {
			return serverGroup;
		}

		/**
		 * To set the serverGroup
		 * 
		 * @param serverGroup
		 * 			String value represents serverGroup
		 */
		
		public void setServerGroup(String serverGroup) {
			this.serverGroup = serverGroup;
		}

		/**
		 * To get the sessionStatusType details
		 * 
		 * @return String sessionStatusType
		 */
		
		public String getSessionStatusType() {
			return sessionStatusType;
		}
		
		
		/**
		 * To set thes essionStatusType
		 * 
		 * @param users
		 * 			String value represents sessionStatusType
		 */

		public void setSessionStatusType(String sessionStatusType) {
			this.sessionStatusType = sessionStatusType;
		}
		
		/**
		 * To get the sessionTimestamp
		 * 
		 * @return String sessionTimestamp
		 */

		public String getSessionTimestamp() {
			return sessionTimestamp;
		}
		
		/**
		 * To set the sessionTimestamp
		 * 
		 * @param sessionTimestamp
		 * 			String value represents sessionTimestamp
		 */

		public void setSessionTimestamp(String sessionTimestamp) {
			this.sessionTimestamp = sessionTimestamp;
		}
		
		
		/**
		 * To get the startVolume
		 * 
		 * @return String startVolume
		 */

		public String getStartVolume() {
			return startVolume;
		}

		/**
		 * To set the startVolume
		 * 
		 * @param startVolume
		 * 			String value represents startVolume
		 */
		public void setStartVolume(String startVolume) {
			this.startVolume = startVolume;
		}

		/**
		 * To get the stopped
		 * 
		 * @return String stopped
		 */
		
		public String getStopped() {
			return stopped;
		}

		/**
		 * To set the stopped
		 * 
		 * @param stopped
		 * 			String value represents stopped
		 */
		public void setStopped(String stopped) {
			this.stopped = stopped;
		}

		/**
		 * To get the throttlingStartVolume
		 * 
		 * @return String throttlingStartVolume
		 */
		
		public String getThrottlingStartVolume() {
			return throttlingStartVolume;
		}

		
		/**
		 * To set the throttlingStartVolume
		 * 
		 * @param throttlingStartVolume
		 * 			String value represents throttlingStartVolume
		 */
		public void setThrottlingStartVolume(String throttlingStartVolume) {
			this.throttlingStartVolume = throttlingStartVolume;
		}

		/**
		 * To get the throttlingVolume 
		 * 
		 * @return String throttlingVolume
		 */
		
		public String getThrottlingVolume() {
			return throttlingVolume;
		}

		/**
		 * To set the throttlingVolume 
		 * 
		 * @param throttlingVolume
		 * 			String value represents throttlingVolume
		 */
		public void setThrottlingVolume(String throttlingVolume) {
			this.throttlingVolume = throttlingVolume;
		}

		/**
		 * To get the uid detail
		 * 
		 * @return String uid
		 */
		
		public String getUid() {
			return uid;
		}

		
		/**
		 * To set the uid detail
		 * 
		 * @param uid
		 * 			String value represents uid
		 */
		public void setUid(String uid) {
			this.uid = uid;
		}
		/**
		 * To get the userIdentifier
		 * 
		 * @return userIdentifier
		 */
		
		public String getUserIdentifier() {
			return userIdentifier;
		}

		/**
		 * To set the userIdentifier details
		 * 
		 * @param userIdentifier
		 * 			String value represents userIdentifier
		 */
		public void setUserIdentifier(String userIdentifier) {
			this.userIdentifier = userIdentifier;
		}

		/**
		 * To get the volume
		 * 
		 * @return volume
		 */
		public String getVolume() {
			return volume;
		}
		
		
		/**
		 * To set the volume
		 * 
		 * @param volume
		 * 			String represents volume
		 */

		public void setVolume(String volume) {
			this.volume = volume;
		}

		public RatingGroup getRatingGroup() {
			return ratingGroup;
		}

		public void setRatingGroup(RatingGroup ratingGroup) {
			this.ratingGroup = ratingGroup;
		}
		
	}
}


