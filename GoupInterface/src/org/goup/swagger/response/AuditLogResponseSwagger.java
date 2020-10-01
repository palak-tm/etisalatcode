/**
 * This package contains class for API, AuditLogs swagger response.
 */
package org.goup.swagger.response;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * This class is used for API audit logs swagger response.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-03
 */
public class AuditLogResponseSwagger {
	
	private String description;
	private List<AuditLogResponse> object;
	private boolean valid;

	/**
	 * To get description
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * To set description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * To Get audit log response objects list
	 * @return List<AuditLogResponse>
	 */
	public List<AuditLogResponse> getObject() {
		return object;
	}

	/**
	 * To set audit log response list
	 * @param object
	 * 			list of audit log response data
	 */
	public void setObject(List<AuditLogResponse> object) {
		this.object = object;
	}

	/**
	 * To check valid flag
	 * @return {@link Boolean}
	 */
	public boolean isValid() {
		return valid;
	}

	
	/**
	 * To set valid flag
	 * @param valid
	 * 			boolean value true/false
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}


/**
 * This class is used for API audit logs response.
 * 
 * @author sanjay
 */
class AuditLogResponse {

	private String logId;
	private String notificationAuditLogId;
	private String logDescription;
	private String token;
	private String endNodeName;
	private String endNodeIP;
	private String notificationType;
	private String apiUrl;
	private String bodyParameter;
	private String headerParameter;
	private String apiType;
	private String dbUrl;
	private String dbDriver;
	private String tableName;
	private String tableParameter;
	private String methodType;
	private String controllerName;
	private String methodName;
	private String hostIP;

	/**
	 * To get log id
	 * @return String
	 */
	public String getLogId() {
		return logId;
	}

	/**
	 * To set log id
	 * @param logId
	 *        the logId to be set
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}

	/**
	 * To get notification audit log id
	 * @return String
	 */
	public String getNotificationAuditLogId() {
		return notificationAuditLogId;
	}

	/**
	 * To set notification audit log id
	 * @param notificationAuditLogId
	 *        String value represents the notificationAuditLogId to be set
	 */
	public void setNotificationAuditLogId(String notificationAuditLogId) {
		this.notificationAuditLogId = notificationAuditLogId;
	}

	/**
	 * To get log description
	 * @return String
	 */
	public String getLogDescription() {
		return logDescription;
	}

	/**
	 * To set log description
	 * @param log_description
	 *        the log_description to be set
	 */
	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}

	/**
	 * To get the token
	 * @return String
	 */
	public String getToken() {
		return token;
	}

	/**
	 * To set the token
	 * @param token
	 *        the token to be set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * To get the end node name
	 * @return String
	 */
	public String getEndNodeName() {
		return endNodeName;
	}

	/**
	 * To set the end node name
	 * @param endNodeName
	 *        the end_node_name to be set
	 */
	public void setEndNodeName(String endNodeName) {
		this.endNodeName = endNodeName;
	}

	/**
	 * to get the end node Ip Address
	 * @return String
	 */
	public String getEndNodeIP() {
		return endNodeIP;
	}

	/**
	 * to set the end Node IP Address
	 * @param endNodeIP
	 *        the end_node_ip to be set
	 */
	public void setEndNodeIP(String endNodeIP) {
		this.endNodeIP = endNodeIP;
	}

	/**
	 * To get the notification type
	 * @return String
	 */
	public String getNotificationType() {
		return notificationType;
	}

	/**
	 * To set the notification type
	 * @param notificationType
	 *        the notification_type to be set
	 */
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * To get the API url
	 * @return String
	 */
	public String getApiUrl() {
		return apiUrl;
	}

	/**
	 * To set the API url
	 * @param apiUrl
	 *        the api_url to be set
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	/**
	 * To get the body parameter name
	 * @return String
	 */
	public String getBodyParameter() {
		return bodyParameter;
	}

	/**
	 * to set the body parameter
	 * @param bodyParameter
	 *        the body_parameter to be set
	 */
	public void setBodyParameter(String bodyParameter) {
		this.bodyParameter = bodyParameter;
	}

	/**
	 * to get the header parameter
	 * @return String
	 */
	public String getHeaderParameter() {
		return headerParameter;
	}

	/**
	 * To set the header parameter
	 * @param headerParameter
	 *        the header_parameter to be set
	 */
	public void setHeaderParameter(String headerParameter) {
		this.headerParameter = headerParameter;
	}

	/**
	 * To get the API type
	 * @return String
	 */
	public String getApiType() {
		return apiType;
	}

	/**
	 * To set the API type
	 * @param apiType
	 *        the api_type to be set
	 */
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	/**
	 * To get the database url
	 * @return String
	 */
	public String getDbUrl() {
		return dbUrl;
	}

	/**
	 * To set the database url
	 * @param dbUrl
	 *        the db_url to be set
	 */
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	/**
	 * to get the database driver name
	 * @return String
	 */
	public String getDbDriver() {
		return dbDriver;
	}

	/**
	 * To set the database driver name
	 * @param dbDriver
	 *        the db_driver name to be set
	 */
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	/**
	 * To get the database table name
	 * @return String
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * To set the database table name
	 * @param tableName
	 *        the table_name to be set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * To get the table parameter name
	 * @return String
	 */
	public String getTableParameter() {
		return tableParameter;
	}

	/**
	 * To set the table parameter
	 * @param tableParameter
	 *        the table_parameter to be set
	 */
	public void setTableParameter(String tableParameter) {
		this.tableParameter = tableParameter;
	}

	/**
	 * To get the method type
	 * @return String
	 */
	public String getMethodType() {
		return methodType;
	}

	/**
	 * To set the method type
	 * @param methodType
	 *        the method_type to be set
	 */
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	/**
	 * To get the controller name
	 * @return String
	 */
	public String getControllerName() {
		return controllerName;
	}

	/**
	 * To set the controller name
	 * @param controllerName
	 *        the controller_name to be set
	 */
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	/**
	 * To get the method name
	 * @return String
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * To set the method name
	 * @param methodName
	 *        the method_name to be set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * To get the host Ip Address
	 * @return String
	 */
	public String getHostIP() {
		return hostIP;
	}

	/**
	 * To set the host Ip Address
	 * @param hostIP
	 *        the host_ip to be set
	 */
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}

}
