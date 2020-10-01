/**
 * This Package contains Service classes for GOUP APIs.
 */
package org.goup.services;

import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class use as Service to get ALL the AUdit log on the basis of dates or log_id.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-01
 */
@Service
public class AuditServices {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	private static final String USER_NAME = "user_name";
	private static final String USER_PASS = "password";
	
	@Autowired
	Environment environment;

	@Autowired
	private GenericProcess genericProcess;
	
	@Autowired(required = true)
	private GenericMethodService methodService;
	
	/**
	 * instantiate logger object
	 */
	Logger logger = Logger.getLogger(AuditServices.class);
	
	/**
	 * Method to get Logs application wise on the basis of their user_name between the
	 * given dates
	 * 
	 * @param map
	 *            Contains start_time and end_time
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> auditLogGetAll(String startDate, String endDate, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/* To get user_name and password from the encoded string coming in
		 * header in parameter name Authorization
		 */
		Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
		
		/* Set attribute of user_name and password in request which will be
		 * access by OL core.
		 */
		request.setAttribute(USER_NAME, map.get(USER_NAME));
		request.setAttribute(USER_PASS, map.get(USER_PASS));
		
		/* Defining parameter Map which will be passing to OL core for
		 * validation and transformation and pushing data in kafka queue for
		 * ASYNC APIs or for SYNC API.
		 */
		Map<String, String> parameterMap = new LinkedHashMap<>();
		
		/* Putting Additional Parameter in MAP which will be used by OL core to
		 * send the call to endnodes.
		 */
		parameterMap.put("start_date", startDate);
		parameterMap.put("end_date", endDate);
		
		// Calling OL Core genericExecuteApiMethod Method to execute the API and Returning Response
		return methodService.auditLogByUser(map.get(USER_NAME), startDate, endDate,
				request, response);

	}
	
	
	/**
	 * Method to get Logs log_id wise
	 * 
	 * @param map
	 *            Contains log_id to gets its all logs
	  * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> auditLogGetById(String trackingMessageHeader, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/* To get user_name and password from the encoded string coming in
		 * header in parameter name Authorization
		 */
		Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
		
		/* Set attribute of user_name and password in request which will be
		 * access by OL core.
		 */
		request.setAttribute(USER_NAME, map.get(USER_NAME));
		request.setAttribute(USER_PASS, map.get(USER_PASS));
		
		/* Defining parameter Map which will be passing to OL core for
		 * validation and transformation and pushing data in kafka queue for
		 * ASYNC APIs or for SYNC API.
		 */
		Map<String, String> parameterMap = new LinkedHashMap<>();
		
		/* Putting Additional Parameter in MAP which will be used by OL core to
		 * send the call to endnodes.
		 */
		parameterMap.put("tracking_message_header", trackingMessageHeader);
		
		//  Calling OL Core genericExecuteApiMethod Method to execute the API and Returning Response
		
		return methodService.auditLogById(trackingMessageHeader, request, response);

	}
	
	
	/**
	 * Inserting Audit Log with its required Parameter
	 * 
	 * @param logType
	 * @param logMessage
	 * @param logData
	 * @param request
	 *            
	 * @throws Exception
	 */
	public void auditLogInsert(String logType, String logMessage, String logData, HttpServletRequest request) {
		try {
			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put("in_tracking_message_header", request.getHeader("requestid"));
			inputParamMap.put("in_log_time", String.valueOf((int) (new Date().getTime() / 1000)));
			inputParamMap.put("in_log_type", logType);
			inputParamMap.put("in_log_message", logMessage);
			inputParamMap.put("in_log_data", logData);			
			inputParamMap.put("in_ip_address", request.getRemoteHost());
			inputParamMap.put("in_api_name", request.getRequestURI());
			inputParamMap.put("in_api_method_type", request.getMethod());
			inputParamMap.put("in_country_code", request.getHeader("country_code"));
			inputParamMap.put("in_operator_code", request.getHeader("operator"));
			
			genericProcess.GenericProcedureCalling("4", inputParamMap, null, request, null);

		} catch (Exception e) {
			/**
			 * To Print Exception if it comes in console and throw exception
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error(e);

		}

	}
	
	
}
