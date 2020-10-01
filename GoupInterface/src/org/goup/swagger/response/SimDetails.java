/**
 * This package contain the  modal classes for swagger documentation of GOUP Router apis
 */
package org.goup.swagger.response;

/**
 * Import classes to access their functionality 
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is used as modal class for getDataPlan api response
 * 
 * @author sanjay
 * @version 1.0
 * @Since 2019-04-25
 *
 */
@ApiModel
public class SimDetails {
	
private String accountId ;
	
	@ApiModelProperty(value="accountNoData", example="false")
	private String accountNoData ;
	
	
	@ApiModelProperty(value="accountType", example="HPUKRecurring4")
	private String accountType ;
	
	@ApiModelProperty(value="accountValid", example="2019-07-29 11:26")
	private String accountValid ;
	
	@ApiModelProperty(value="activeNetworkMccMnc", example="")
	private String activeNetworkMccMnc ;
	
	@ApiModelProperty(value="birthday", example="1992-03-31")
	private String birthday ;
	
	@ApiModelProperty(value="client", example="client_28_type")
	private String client ;
	
	@ApiModelProperty(value="consumedUserPurchaseActivationEnabled", example="true")
	private String consumedUserPurchaseActivationEnabled ;
	
	@ApiModelProperty(value="contactMsisdn", example="46769802130")
	private String contactMsisdn ;
	
	@ApiModelProperty(value="countryIsoCode", example="AU")
	private String countryIsoCode ;
	
	@ApiModelProperty(value="currentNetwork", example="GBRHU")
	private String currentNetwork ;
	
	@ApiModelProperty(value="currentNetworkMccMnc", example="")
	private String currentNetworkMccMnc ;
	
	@ApiModelProperty(value="device", example="")
	private String device ;
	
	@ApiModelProperty(value="deviceToken", example="")
	private String deviceToken ;
	
	@ApiModelProperty(value="email", example="amangrwl30@gmail.com")
	private String email ;
	
	@ApiModelProperty(value="emailNotif", example="false")
	private String emailNotif ;
	
	@ApiModelProperty(value="emailVerified", example="false")
	private String emailVerified ;
	
	@ApiModelProperty(value="env", example="uk")
	private String env ;
	
	@ApiModelProperty(value="facebook", example="false")
	private String facebook ;
	
	@ApiModelProperty(value="firstName", example="sachin")
	private String firstName ;
	
	@ApiModelProperty(value="gender", example="")
	private String gender ;
	
	@ApiModelProperty(value="hasApp", example="false")
	private String hasApp ;
	
	@ApiModelProperty(value="iccid", example="8946270044400176972")
	private String iccid ;
	
	@ApiModelProperty(value="imei", example="")
	private String imei ;
	
	@ApiModelProperty(value="imsi", example="404441111111112")
	private String imsi ;
	
	@ApiModelProperty(value="language", example="en-UK")
	private String language ;
	
	@ApiModelProperty(value="lastName", example="nahars")
	private String lastName ;
	
	@ApiModelProperty(value="lowDataNotificationEnabled", example="true")
	private String lowDataNotificationEnabled ;
	
	@ApiModelProperty(value="m2mEnabled", example="true")
	private String m2mEnabled ;
	
	@ApiModelProperty(value="machine", example="false")
	private String machine ;
	
	@ApiModelProperty(value="marketing", example="false")
	private String marketing ;
	
	@ApiModelProperty(value="migratedEnvironment", example="")
	private String migratedEnvironment ;
	
	@ApiModelProperty(value="mobile", example="true")
	private String mobile ;
	
	@ApiModelProperty(value="msisdn", example="46769802130")
	private String msisdn ;
	
	@ApiModelProperty(value="network", example="GBRHU")
	private String network ;
	
	@ApiModelProperty(value="networkMccMnc", example="")
	private String networkMccMnc ;
	
	@ApiModelProperty(value="noDataNotificationEnabled", example="true")
	private String noDataNotificationEnabled ;
	
	@ApiModelProperty(value="notificationEmail", example="tst@gmail.com")
	private String notificationEmail ;
	
	@ApiModelProperty(value="notificationEmailOverride", example="true")
	private String notificationEmailOverride ;
	
	@ApiModelProperty(value="notificationUuid", example="6b842041c3a246ab964d6a21fb4d4a27")
	private String notificationUuid ;
	
	@ApiModelProperty(value="payAgreement", example="false")
	private String payAgreement ;
	
	@ApiModelProperty(value="paymentRefused", example="false")
	private String paymentRefused ;
	
	@ApiModelProperty(value="personalId", example="555123455555")
	private String personalId ;
	
	@ApiModelProperty(value="redirectionConfigExternalId", example="")
	private String redirectionConfigExternalId ;
	
	@ApiModelProperty(value="registrationCountryIsoCode", example="AU")
	private String registrationCountryIsoCode ;
	
	@ApiModelProperty(value="serverGroup", example="HP")
	private String serverGroup ;
	
	@ApiModelProperty(value="sessionStatusType", example="")
	private String sessionStatusType ;
	
	@ApiModelProperty(value="simStatus", example="enabled")
	private String simStatus ;
	
	@ApiModelProperty(value="simSwapSuccess", example="false")
	private String simSwapSuccess ;
	
	@ApiModelProperty(value="startVolume", example="0")
	private String startVolume ;
	
	@ApiModelProperty(value="stopped", example="false")
	private String stopped ;
	
	@ApiModelProperty(value="tempPassword", example="false")
	private String tempPassword ;
	
	@ApiModelProperty(value="updateUserData", example="false")
	private String updateUserData ;
	
	@ApiModelProperty(value="userIdentifier", example="defaults2497fe237e7649a680b4af4a7a0e6cf8")
	private String userIdentifier ;
	
	@ApiModelProperty(value="userType", example="M2M_EXTRA")
	private String userType ;
	
	@ApiModelProperty(value="verificationEmailSendCount", example="0")
	private String verificationEmailSendCount ;
	
	@ApiModelProperty(value="verificationStatus", example="verified")
	private String verificationStatus ;
	
	@ApiModelProperty(value="visitNetwork", example="true")
	private String visitNetwork ;
	
	@ApiModelProperty(value="volume", example="0")
	private String volume ;
	/**
	 * To get the volume
	 * 
	 * @return volume
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * To set the accountId
	 * 
	 * @param accountId
	 * 			String represents accountId
	 */
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

		/**
	 * To get the accountNoData
	 * 
	 * @return accountNoData
	 */
	public String getAccountNoData() {
		return accountNoData;
	}

	/**
	 * To set the accountNoData
	 * 
	 * @param accountNoData
	 * 			String represents accountNoData
	 */
	
	public void setAccountNoData(String accountNoData) {
		this.accountNoData = accountNoData;
	}
	/**
	 * To get the accountType
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * To set the accountType
	 * 
	 * @param accountType
	 * 			String represents accountType
	 */

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * To get the accountValid
	 * 
	 * @return accountValid
	 */
	public String getAccountValid() {
		return accountValid;
	}

	/**
	 * To set the volume
	 * 
	 * @param volume
	 * 			String represents volume
	 */
	public void setAccountValid(String accountValid) {
		this.accountValid = accountValid;
	}
	/**
	 * To get the activeNetworkMccMnc
	 * 
	 * @return activeNetworkMccMnc
	 */
	public String getActiveNetworkMccMnc() {
		return activeNetworkMccMnc;
	}

	/**
	 * To set the activeNetworkMccMnc
	 * 
	 * @param activeNetworkMccMnc
	 * 			String represents activeNetworkMccMnc
	 */
	public void setActiveNetworkMccMnc(String activeNetworkMccMnc) {
		this.activeNetworkMccMnc = activeNetworkMccMnc;
	}
	/**
	 * To get the birthday
	 * 
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	
	/**
	 * To set the birthday
	 * 
	 * @param birthday
	 * 			String represents birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * To get the client
	 * 
	 * @return client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * To set the client
	 * 
	 * @param client
	 * 			String represents client
	 */
	public void setClient(String client) {
		this.client = client;
	}
	/**
	 * To get the consumedUserPurchaseActivationEnabled
	 * 
	 * @return consumedUserPurchaseActivationEnabled
	 */
	public String getConsumedUserPurchaseActivationEnabled() {
		return consumedUserPurchaseActivationEnabled;
	}

	/**
	 * To set the consumedUserPurchaseActivationEnabled
	 * 
	 * @param consumedUserPurchaseActivationEnabled
	 * 			String represents consumedUserPurchaseActivationEnabled
	 */
	public void setConsumedUserPurchaseActivationEnabled(String consumedUserPurchaseActivationEnabled) {
		this.consumedUserPurchaseActivationEnabled = consumedUserPurchaseActivationEnabled;
	}
	/**
	 * To get the contactMsisdn
	 * 
	 * @return contactMsisdn
	 */
	public String getContactMsisdn() {
		return contactMsisdn;
	}
	/**
	 * To set the contactMsisdn
	 * 
	 * @param contactMsisdn
	 * 			String represents contactMsisdn
	 */
	public void setContactMsisdn(String contactMsisdn) {
		this.contactMsisdn = contactMsisdn;
	}
	/**
	 * To get the countryIsoCode
	 * 
	 * @return countryIsoCode
	 */
	public String getCountryIsoCode() {
		return countryIsoCode;
	}
	/**
	 * To set the countryIsoCode
	 * 
	 * @param countryIsoCode
	 * 			String represents countryIsoCode
	 */
	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}
	/**
	 * To get the currentNetwork
	 * 
	 * @return currentNetwork
	 */
	public String getCurrentNetwork() {
		return currentNetwork;
	}
	/**
	 * To set the currentNetwork
	 * 
	 * @param currentNetwork
	 * 			String represents currentNetwork
	 */
	public void setCurrentNetwork(String currentNetwork) {
		this.currentNetwork = currentNetwork;
	}
	/**
	 * To get the currentNetworkMccMnc
	 * 
	 * @return currentNetworkMccMnc
	 */
	public String getCurrentNetworkMccMnc() {
		return currentNetworkMccMnc;
	}
	/**
	 * To set the currentNetworkMccMnc
	 * 
	 * @param currentNetworkMccMnc
	 * 			String represents currentNetworkMccMnc
	 */
	public void setCurrentNetworkMccMnc(String currentNetworkMccMnc) {
		this.currentNetworkMccMnc = currentNetworkMccMnc;
	}
	/**
	 * To get the device
	 * 
	 * @return device
	 */
	public String getDevice() {
		return device;
	}
	/**
	 * To set the device
	 * 
	 * @param device
	 * 			String represents device
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	 * To get the deviceToken
	 * 
	 * @return deviceToken
	 */
	public String getDeviceToken() {
		return deviceToken;
	}
	/**
	 * To set the deviceToken
	 * 
	 * @param deviceToken
	 * 			String represents deviceToken
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	/**
	 * To get the email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * To set the email
	 * 
	 * @param email
	 * 			String represents email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * To get the emailNotif
	 * 
	 * @return emailNotif
	 */
	public String getEmailNotif() {
		return emailNotif;
	}
	/**
	 * To set the emailNotif
	 * 
	 * @param emailNotif
	 * 			String represents emailNotif
	 */
	public void setEmailNotif(String emailNotif) {
		this.emailNotif = emailNotif;
	}
	/**
	 * To get the emailVerified
	 * 
	 * @return emailVerified
	 */
	public String getEmailVerified() {
		return emailVerified;
	}
	/**
	 * To set the emailVerified
	 * 
	 * @param emailVerified
	 * 			String represents emailVerified
	 */
	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}
	/**
	 * To get the env
	 * 
	 * @return env
	 */
	public String getEnv() {
		return env;
	}
	/**
	 * To set the env
	 * 
	 * @param env
	 * 			String represents env
	 */
	public void setEnv(String env) {
		this.env = env;
	}
	/**
	 * To get the facebook
	 * 
	 * @return facebook
	 */
	public String getFacebook() {
		return facebook;
	}
	/**
	 * To set the facebook
	 * 
	 * @param facebook
	 * 			String represents facebook
	 */
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	/**
	 * To get the firstName
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * To set the firstName
	 * 
	 * @param firstName
	 * 			String represents firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * To get the gender
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * To set the gender
	 * 
	 * @param gender
	 * 			String represents gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * To get the hasApp
	 * 
	 * @return hasApp
	 */
	public String getHasApp() {
		return hasApp;
	}
	/**
	 * To set the hasApp
	 * 
	 * @param hasApp
	 * 			String represents hasApp
	 */
	public void setHasApp(String hasApp) {
		this.hasApp = hasApp;
	}
	/**
	 * To get the iccid
	 * 
	 * @return iccid
	 */
	public String getIccid() {
		return iccid;
	}
	/**
	 * To set the iccid
	 * 
	 * @param iccid
	 * 			String represents iccid
	 */
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	/**
	 * To get the imei
	 * 
	 * @return imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * To set the imei
	 * 
	 * @param imei
	 * 			String represents imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * To get the imsi
	 * 
	 * @return imsi
	 */
	public String getImsi() {
		return imsi;
	}
	/**
	 * To set the imsi
	 * 
	 * @param imsi
	 * 			String represents imsi
	 */
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	/**
	 * To get the language
	 * 
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * To set the language
	 * 
	 * @param language
	 * 			String represents language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * To get the lastName
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * To set the lastName
	 * 
	 * @param lastName
	 * 			String represents lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * To get the lowDataNotificationEnabled
	 * 
	 * @return lowDataNotificationEnabled
	 */
	public String getLowDataNotificationEnabled() {
		return lowDataNotificationEnabled;
	}

	/**
	 * To set the lowDataNotificationEnabled
	 * 
	 * @param lowDataNotificationEnabled
	 * 			String represents lowDataNotificationEnabled
	 */
	public void setLowDataNotificationEnabled(String lowDataNotificationEnabled) {
		this.lowDataNotificationEnabled = lowDataNotificationEnabled;
	}
	/**
	 * To get the m2mEnabled
	 * 
	 * @return m2mEnabled
	 */
	public String getM2mEnabled() {
		return m2mEnabled;
	}
	/**
	 * To set the m2mEnabled
	 * 
	 * @param m2mEnabled
	 * 			String represents m2mEnabled
	 */
	public void setM2mEnabled(String m2mEnabled) {
		this.m2mEnabled = m2mEnabled;
	}
	/**
	 * To get the machine
	 * 
	 * @return machine
	 */
	public String getMachine() {
		return machine;
	}

	/**
	 * To set the machine
	 * 
	 * @param machine
	 * 			String represents volume
	 */
	public void setMachine(String machine) {
		this.machine = machine;
	}
	/**
	 * To get the marketing
	 * 
	 * @return marketing
	 */
	public String getMarketing() {
		return marketing;
	}

	/**
	 * To set the marketing
	 * 
	 * @param marketing
	 * 			String represents marketing
	 */
	public void setMarketing(String marketing) {
		this.marketing = marketing;
	}
	/**
	 * To get the migratedEnvironment
	 * 
	 * @return migratedEnvironment
	 */
	public String getMigratedEnvironment() {
		return migratedEnvironment;
	}
	
	/**
	 * To set the migratedEnvironment
	 * 
	 * @param migratedEnvironment
	 * 			String represents migratedEnvironment
	 */

	public void setMigratedEnvironment(String migratedEnvironment) {
		this.migratedEnvironment = migratedEnvironment;
	}
	/**
	 * To get the mobile
	 * 
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * To set the mobile
	 * 
	 * @param mobile
	 * 			String represents mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * To get the msisdn
	 * 
	 * @return msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}
	/**
	 * To set the msisdn
	 * 
	 * @param msisdn
	 * 			String represents msisdn
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	/**
	 * To get the network
	 * 
	 * @return network
	 */
	public String getNetwork() {
		return network;
	}
	/**
	 * To set the network
	 * 
	 * @param network
	 * 			String represents network
	 */
	public void setNetwork(String network) {
		this.network = network;
	}
	/**
	 * To get the networkMccMnc
	 * 
	 * @return networkMccMnc
	 */
	public String getNetworkMccMnc() {
		return networkMccMnc;
	}
	/**
	 * To set the networkMccMnc
	 * 
	 * @param networkMccMnc
	 * 			String represents networkMccMnc
	 */
	public void setNetworkMccMnc(String networkMccMnc) {
		this.networkMccMnc = networkMccMnc;
	}
	/**
	 * To get the noDataNotificationEnabled
	 * 
	 * @return noDataNotificationEnabled
	 */
	public String getNoDataNotificationEnabled() {
		return noDataNotificationEnabled;
	}
	/**
	 * To set the noDataNotificationEnabled
	 * 
	 * @param noDataNotificationEnabled
	 * 			String represents noDataNotificationEnabled
	 */
	public void setNoDataNotificationEnabled(String noDataNotificationEnabled) {
		this.noDataNotificationEnabled = noDataNotificationEnabled;
	}
	/**
	 * To get the notificationEmail
	 * 
	 * @return notificationEmail
	 */
	public String getNotificationEmail() {
		return notificationEmail;
	}
	/**
	 * To set the notificationEmail
	 * 
	 * @param notificationEmail
	 * 			String represents notificationEmail
	 */
	public void setNotificationEmail(String notificationEmail) {
		this.notificationEmail = notificationEmail;
	}
	/**
	 * To get the notificationEmailOverride
	 * 
	 * @return notificationEmailOverride
	 */
	public String getNotificationEmailOverride() {
		return notificationEmailOverride;
	}
	
	/**
	 * To set the notificationEmailOverride
	 * 
	 * @param notificationEmailOverride
	 * 			String represents notificationEmailOverride
	 */

	public void setNotificationEmailOverride(String notificationEmailOverride) {
		this.notificationEmailOverride = notificationEmailOverride;
	}
	/**
	 * To get the notificationUuid
	 * 
	 * @return notificationUuid
	 */
	public String getNotificationUuid() {
		return notificationUuid;
	}
	/**
	 * To set the notificationUuid
	 * 
	 * @param notificationUuid
	 * 			String represents notificationUuid
	 */
	public void setNotificationUuid(String notificationUuid) {
		this.notificationUuid = notificationUuid;
	}
	/**
	 * To get the payAgreement
	 * 
	 * @return payAgreement
	 */
	public String getPayAgreement() {
		return payAgreement;
	}
	/**
	 * To set the payAgreement
	 * 
	 * @param payAgreement
	 * 			String represents payAgreement
	 */
	public void setPayAgreement(String payAgreement) {
		this.payAgreement = payAgreement;
	}
	/**
	 * To get the paymentRefused
	 * 
	 * @return paymentRefused
	 */
	public String getPaymentRefused() {
		return paymentRefused;
	}

	/**
	 * To set the paymentRefused
	 * 
	 * @param paymentRefused
	 * 			String represents paymentRefused
	 */
	public void setPaymentRefused(String paymentRefused) {
		this.paymentRefused = paymentRefused;
	}
	/**
	 * To get the personalId
	 * 
	 * @return personalId
	 */
	public String getPersonalId() {
		return personalId;
	}

	/**
	 * To set the personalId
	 * 
	 * @param personalId
	 * 			String represents personalId
	 */
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	/**
	 * To get the redirectionConfigExternalId
	 * 
	 * @return redirectionConfigExternalId
	 */
	public String getRedirectionConfigExternalId() {
		return redirectionConfigExternalId;
	}

	/**
	 * To set the redirectionConfigExternalId
	 * 
	 * @param redirectionConfigExternalId
	 * 			String represents redirectionConfigExternalId
	 */
	public void setRedirectionConfigExternalId(String redirectionConfigExternalId) {
		this.redirectionConfigExternalId = redirectionConfigExternalId;
	}
	/**
	 * To get the registrationCountryIsoCode
	 * 
	 * @return registrationCountryIsoCode
	 */
	public String getRegistrationCountryIsoCode() {
		return registrationCountryIsoCode;
	}

	/**
	 * To set the registrationCountryIsoCode
	 * 
	 * @param registrationCountryIsoCode
	 * 			String represents registrationCountryIsoCode
	 */
	public void setRegistrationCountryIsoCode(String registrationCountryIsoCode) {
		this.registrationCountryIsoCode = registrationCountryIsoCode;
	}
	/**
	 * To get the serverGroup
	 * 
	 * @return serverGroup
	 */
	public String getServerGroup() {
		return serverGroup;
	}
	/**
	 * To set the serverGroup
	 * 
	 * @param serverGroup
	 * 			String represents serverGroup
	 */
	public void setServerGroup(String serverGroup) {
		this.serverGroup = serverGroup;
	}
	/**
	 * To get the sessionStatusType
	 * 
	 * @return sessionStatusType
	 */
	public String getSessionStatusType() {
		return sessionStatusType;
	}

	/**
	 * To set the sessionStatusType
	 * 
	 * @param sessionStatusType
	 * 			String represents sessionStatusType
	 */
	public void setSessionStatusType(String sessionStatusType) {
		this.sessionStatusType = sessionStatusType;
	}
	/**
	 * To get the simStatus
	 * 
	 * @return simStatus
	 */
	public String getSimStatus() {
		return simStatus;
	}
	/**
	 * To set the simStatus
	 * 
	 * @param simStatus
	 * 			String represents simStatus
	 */
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	/**
	 * To get the simSwapSuccess
	 * 
	 * @return simSwapSuccess
	 */
	public String getSimSwapSuccess() {
		return simSwapSuccess;
	}
	/**
	 * To set the simSwapSuccess
	 * 
	 * @param simSwapSuccess
	 * 			String represents simSwapSuccess
	 */
	public void setSimSwapSuccess(String simSwapSuccess) {
		this.simSwapSuccess = simSwapSuccess;
	}
	/**
	 * To get the startVolume
	 * 
	 * @return startVolume
	 */
	public String getStartVolume() {
		return startVolume;
	}
	/**
	 * To set the startVolume
	 * 
	 * @param startVolume
	 * 			String represents startVolume
	 */
	public void setStartVolume(String startVolume) {
		this.startVolume = startVolume;
	}
	/**
	 * To get the stopped
	 * 
	 * @return stopped
	 */
	public String getStopped() {
		return stopped;
	}
	/**
	 * To set the stopped
	 * 
	 * @param stopped
	 * 			String represents stopped
	 */
	public void setStopped(String stopped) {
		this.stopped = stopped;
	}
	/**
	 * To get the tempPassword
	 * 
	 * @return tempPassword
	 */
	public String getTempPassword() {
		return tempPassword;
	}
	/**
	 * To set the tempPassword
	 * 
	 * @param tempPassword
	 * 			String represents tempPassword
	 */
	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
	/**
	 * To get the updateUserData
	 * 
	 * @return updateUserData
	 */
	public String getUpdateUserData() {
		return updateUserData;
	}
	/**
	 * To set the updateUserData
	 * 
	 * @param updateUserData
	 * 			String represents updateUserData
	 */
	public void setUpdateUserData(String updateUserData) {
		this.updateUserData = updateUserData;
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
	 * To set the userIdentifier
	 * 
	 * @param userIdentifier
	 * 			String represents userIdentifier
	 */
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	/**
	 * To get the userType
	 * 
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * To set the userType
	 * 
	 * @param userType
	 * 			String represents userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * To get the verificationEmailSendCount
	 * 
	 * @return verificationEmailSendCount
	 */
	public String getVerificationEmailSendCount() {
		return verificationEmailSendCount;
	}

	/**
	 * To set the verificationEmailSendCount
	 * 
	 * @param verificationEmailSendCount
	 * 			String represents verificationEmailSendCount
	 */
	public void setVerificationEmailSendCount(String verificationEmailSendCount) {
		this.verificationEmailSendCount = verificationEmailSendCount;
	}
	/**
	 * To get the verificationStatus
	 * 
	 * @return verificationStatus
	 */
	public String getVerificationStatus() {
		return verificationStatus;
	}

	/**
	 * To set the verificationStatus
	 * 
	 * @param verificationStatus
	 * 			String represents verificationStatus
	 */
	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	/**
	 * To get the visitNetwork
	 * 
	 * @return visitNetwork
	 */
	public String getVisitNetwork() {
		return visitNetwork;
	}

	/**
	 * To set the volvisitNetworkume
	 * 
	 * @param visitNetwork
	 * 			String represents visitNetwork
	 */
	public void setVisitNetwork(String visitNetwork) {
		this.visitNetwork = visitNetwork;
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
	

}

