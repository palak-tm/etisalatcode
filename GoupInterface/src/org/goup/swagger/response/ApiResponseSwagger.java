/**
 * This package contains class for API, AuditLogs swagger response.
 */
package org.goup.swagger.response;

/**
 * This class is used for API call swagger response.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-03
 */
public class ApiResponseSwagger {

	private APIResponse apiResponse;
	private APIErrorResponse error;

	/**
	 * To Get the api response
	 * @return APIResponse
	 */
	public APIResponse getApiResponse() {
		return apiResponse;
	}

	/**
	 * To set the api response
	 * @param apiResponse
	 */
	public void setApiResponse(APIResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

	/** To get the API error response
	 * @return APIErrorResponse
	 */
	public APIErrorResponse getError() {
		return error;
	}
	
	/**
	 * To set the api error response
	 * @param error
	 */
	public void setError(APIErrorResponse error) {
		this.error = error;
	}

}

/**
 * This class icludes methods related to API response.
 * 
 * @author sanjay
 */
class APIResponse {

	private String trackingMessageHeader;


	/** To get message header
	 * @return String
	 */
	public String getTrackingMessageHeader() {
		return trackingMessageHeader;
	}


	/**
	 * To set message Header
	 * @param trackingMessageHeader
	 */
	public void setTrackingMessageHeader(String trackingMessageHeader) {
		this.trackingMessageHeader = trackingMessageHeader;
	}

}

/**
 * This class icludes methods related to API error response.
 * 
 * @author sanjay
 */
class APIErrorResponse {

	private String errorCode;
	private String description;

	/**
	 * To get error code
	 * @return String
	 */
	public String getErrorCode() {
		return errorCode;
	}

	
	/**
	 * To set error code
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * to get description
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

}