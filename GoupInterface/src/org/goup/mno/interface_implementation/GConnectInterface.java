/**
 * This package contains classes related to operators interface api implementation.
 */
package org.goup.mno.interface_implementation;

import java.lang.reflect.Type;
/**
 * To Import Classes to access their functionality
 */
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.goup.constant.AsyncConstant;
import org.goup.request.model.Message;
import org.goup.services.AuditServices;
import org.goup.services.GenericProcess;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * This class use as component to execute all api calls related to GConnect Platform.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-02
 */
@Component
public class GConnectInterface {

	private static final String COUNTRY_CODE = "country_code";
	private static final String OPERATOR_NAME = "operator_name";
	private static final String REQUEST_ID = "request_id";
	private static final String REQ_TRACKING_ID = "requestid";
	private static final String ICCID = "iccid";
	private static final String BAN = "ban";
	private static final String UNIQUE_SIM_IDENTIFIER = "unique_sim_identifier";
	private static final String API_GROUP_NAME = "api_group_name";
	private static final String RETURN_URL = "returnUrl";
	private static final String NOTIFICATION_URL = "returnurl";
	private static final String API_INPUT_PARAMETER_MAP = "api input parameterMap : ";
	private static final String EXCEPTION_OCCURED = "Exception occured :-";
	private static final String CALLING_OL_GENERIC_API_EXECUTE_METHOD = "calling to GOUP OL Core genericExecuteApiMethod";
	private static final String RESPONSE_OL_GENERIC_API_EXECUTE_METHOD = "response from GOUP OL Core genericExecuteApiMethod";
	private static final String RESPONSE_CODE_FROM_OL="response code from OL_Core:-";
	private static final String RESPONSE_FROM_OL="response from OL core:-";
	private static final String RESPONSE_BODY_FROM_OL="response body from OL core:-";
	private static final String DATA_INSERTING_IN_NOTIFICATION_QUEUE="Data Inserting In Nofication Queue...";
	private static final String DATA_INSERTED_IN_NOTIFICATION_QUEUE="Data Inserted In Nofication Queue Successfully..";
	private static final String RETURN_URL_INSERTED_LOG="return url inserted into thirdparty database";
	private static final String NOTIFICATION_INSERT_PROCEDURE_RESULT= "Notification Insert Procedure Result:-";


	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;

	@Autowired(required = true)
	private AuditServices logAudit;

	@Autowired
	private GenericProcess genericProcess;

	/**
	 * instantiate logger
	 */
	Logger logger = Logger.getLogger(GConnectInterface.class);

	/**
	 * This API is used to get sim details on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim details
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimDetails(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sim Details API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimDetails", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sim Details API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sim data usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim data usage
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimUsage(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}


		try {
			logger.info("********************************** Get Sim Usage API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimUsage", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sim Usage API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sim session info on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim session Info
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> simSessionInfo(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sim Session Info API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("simSessionInfo", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sim Session API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to activate sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to activate sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> activateSim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null || genericProcess == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}

		try {
			logger.info("********************************** activate Sim API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("activateSim", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info(RESPONSE_CODE_FROM_OL+responseMessage.getStatusCode());
			logger.info(RESPONSE_FROM_OL+responseMessage.toString());
			logger.info(RESPONSE_BODY_FROM_OL+responseMessage.getBody());

			if (responseMessage.getBody() == null) {
				logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);			
				Map<String, String> inputParamMap = new LinkedHashMap<>();
				inputParamMap.put(REQUEST_ID, request.getHeader(REQ_TRACKING_ID));
				inputParamMap.put(ICCID, request.getHeader(ICCID));
				inputParamMap.put(BAN, request.getHeader(BAN));
				inputParamMap.put(UNIQUE_SIM_IDENTIFIER, request.getHeader(UNIQUE_SIM_IDENTIFIER));
				inputParamMap.put(API_GROUP_NAME, AsyncConstant.GConnectAsyncConstant.ACTIVATE_SIM_API_GROUP);			
				inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
				inputParamMap.put(COUNTRY_CODE, countryCode);
				inputParamMap.put(OPERATOR_NAME, operator);			

				Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);
				logAudit.auditLogInsert("log", RETURN_URL_INSERTED_LOG, result.toString(), request);
				logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
				logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			}

			logger.info("********************** activate Sim API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to deactivate sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to deactivate sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> deactivateSim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null || genericProcess == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}

		try {
			logger.info("********************************** deactivate Sim Info API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("deactivateSim", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info(RESPONSE_CODE_FROM_OL+responseMessage.getStatusCode());
			logger.info(RESPONSE_FROM_OL+responseMessage.toString());
			logger.info(RESPONSE_BODY_FROM_OL+responseMessage.getBody());

			if (responseMessage.getBody() == null) {
				logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);
				Map<String, String> inputParamMap = new LinkedHashMap<>();
				inputParamMap.put(REQUEST_ID, request.getHeader(REQ_TRACKING_ID));
				inputParamMap.put(ICCID, request.getHeader(ICCID));
				inputParamMap.put(BAN, request.getHeader(BAN));
				inputParamMap.put(UNIQUE_SIM_IDENTIFIER, request.getHeader(UNIQUE_SIM_IDENTIFIER));
				inputParamMap.put(API_GROUP_NAME, AsyncConstant.GConnectAsyncConstant.DEACTIVATE_SIM_API_GROUP);			
				inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
				inputParamMap.put(COUNTRY_CODE, countryCode);
				inputParamMap.put(OPERATOR_NAME, operator);			

				Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);
				logAudit.auditLogInsert("log", RETURN_URL_INSERTED_LOG, result.toString(), request);
				logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
				logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			}

			logger.info("********************** deactivate Sim API Execution Ended ******************************");
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to suspend sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to suspend sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> suspendSim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null || genericProcess == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}

		try {
			logger.info("********************************** suspend Sim Info API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("suspendSim", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info(RESPONSE_CODE_FROM_OL+responseMessage.getStatusCode());
			logger.info(RESPONSE_FROM_OL+responseMessage.toString());
			logger.info(RESPONSE_BODY_FROM_OL+responseMessage.getBody());

			if (responseMessage.getBody() == null) {
				logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);
				Map<String, String> inputParamMap = new LinkedHashMap<>();
				inputParamMap.put(REQUEST_ID, request.getHeader(REQ_TRACKING_ID));
				inputParamMap.put(ICCID, request.getHeader(ICCID));
				inputParamMap.put(BAN, request.getHeader(BAN));
				inputParamMap.put(UNIQUE_SIM_IDENTIFIER, request.getHeader(UNIQUE_SIM_IDENTIFIER));
				inputParamMap.put(API_GROUP_NAME, AsyncConstant.GConnectAsyncConstant.SUSPEND_SIM_API_GROUP);			
				inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
				inputParamMap.put(COUNTRY_CODE, countryCode);
				inputParamMap.put(OPERATOR_NAME, operator);			

				Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);
				logAudit.auditLogInsert("log", RETURN_URL_INSERTED_LOG, result.toString(), request);
				logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
				logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			}

			logger.info("********************** suspend Sim API Execution Ended ******************************");
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to reactivate sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to reactivate sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> reactivateSim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null || genericProcess == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}

		try {
			logger.info("********************************** reactivate Sim Info API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("reactivateSim", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info(RESPONSE_CODE_FROM_OL+responseMessage.getStatusCode());
			logger.info(RESPONSE_FROM_OL+responseMessage.toString());
			logger.info(RESPONSE_BODY_FROM_OL+responseMessage.getBody());

			if (responseMessage.getBody() == null) {
				logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);
				Map<String, String> inputParamMap = new LinkedHashMap<>();
				inputParamMap.put(REQUEST_ID, request.getHeader(REQ_TRACKING_ID));
				inputParamMap.put(ICCID, request.getHeader(ICCID));
				inputParamMap.put(BAN, request.getHeader(BAN));
				inputParamMap.put(UNIQUE_SIM_IDENTIFIER, request.getHeader(UNIQUE_SIM_IDENTIFIER));
				inputParamMap.put(API_GROUP_NAME, AsyncConstant.GConnectAsyncConstant.REACTIVATE_SIM_API_GROUP);			
				inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
				inputParamMap.put(COUNTRY_CODE, countryCode);
				inputParamMap.put(OPERATOR_NAME, operator);			

				Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);
				logAudit.auditLogInsert("log", RETURN_URL_INSERTED_LOG, result.toString(), request);
				logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
				logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			}

			logger.info("********************** reactivate Sim API Execution Ended ******************************");
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sim session history on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim session History
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimSessionHistory(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sim Session History API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimSessionHistory", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sim Session History API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to public profile mapping by ESIM.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to public profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> publishProfileMapping(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** publish Profile Mapping API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("publishProfileMapping", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** publish Profile Mapping API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to download profile on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to download profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> downloadProfile(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** download Profile API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("downloadProfile", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info(RESPONSE_CODE_FROM_OL+responseMessage.getStatusCode());
			logger.info(RESPONSE_FROM_OL+responseMessage.toString());
			logger.info(RESPONSE_BODY_FROM_OL+responseMessage.getBody());

			if (responseMessage.getBody() == null) {
				logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);			
				Map<String, String> inputParamMap = new LinkedHashMap<>();
				inputParamMap.put(REQUEST_ID, request.getHeader(REQ_TRACKING_ID));
				inputParamMap.put(ICCID, request.getHeader(ICCID));
				inputParamMap.put(BAN, request.getHeader(BAN));
				inputParamMap.put(UNIQUE_SIM_IDENTIFIER, request.getHeader(UNIQUE_SIM_IDENTIFIER));
				inputParamMap.put(API_GROUP_NAME, "downloadProfile");			
				inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
				inputParamMap.put(COUNTRY_CODE, countryCode);
				inputParamMap.put(OPERATOR_NAME, operator);			

				Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);
				logAudit.auditLogInsert("log", RETURN_URL_INSERTED_LOG, result.toString(), request);
				logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
				logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			}

			logger.info("*************************** download Profile API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to update virtual device settings on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to update virtual device settings
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateVirtualDeviceSettings(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** update Virtual Device Settings API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateVirtualDeviceSettings", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info(RESPONSE_CODE_FROM_OL+responseMessage.getStatusCode());
			logger.info(RESPONSE_FROM_OL+responseMessage.toString());
			logger.info(RESPONSE_BODY_FROM_OL+responseMessage.getBody());

			if (responseMessage.getBody() == null) {
				logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);			
				Map<String, String> inputParamMap = new LinkedHashMap<>();
				inputParamMap.put(REQUEST_ID, request.getHeader(REQ_TRACKING_ID));
				inputParamMap.put(ICCID, request.getHeader(ICCID));
				inputParamMap.put(BAN, request.getHeader(BAN));
				inputParamMap.put(UNIQUE_SIM_IDENTIFIER, request.getHeader(UNIQUE_SIM_IDENTIFIER));
				inputParamMap.put(API_GROUP_NAME, "updateVirtualDeviceSettings");			
				inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
				inputParamMap.put(COUNTRY_CODE, countryCode);
				inputParamMap.put(OPERATOR_NAME, operator);			

				Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);	
				logAudit.auditLogInsert("log", RETURN_URL_INSERTED_LOG, result.toString(), request);
				logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
				logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			}

			logger.info("*************************** update Virtual Device Settings API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to check user is exists or not on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to check user existance
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userExistenceCheck(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** user Existence Check API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userExistenceCheck", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** user Existence Check API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to register user
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to user registration
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userRegistration(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** user Registration API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userRegistration", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** user Registration API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to remove user on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to remove user
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userRemoval(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** user Removal API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userRemoval", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** user Removal API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to update user on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to update user
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateUser(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** update User API called***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateUser", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** update User API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to swap sim of an user.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to sim swap
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userSimSwap(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** user Sim Swap API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userSimSwap", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** user Sim Swap API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	/**
	 * This API is used to user retrieval.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to user retrieval
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userRetrieval(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** user Retrieval API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userRetrieval", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** user Retrieval API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	/**
	 * This API is used to add order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to add order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> addOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("**********************************add Order API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("addOrder", parameterMap,
					request, response);
			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************add Order API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to check order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to check order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> checkOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** check Order API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("checkOrder", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** check Order API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to cancel order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to cancel order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> cancelOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** cancel Order API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("cancelOrder", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** cancel Order API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to retrieve order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to retrieve order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> retrieveOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** retrieve Order API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("retrieveOrder", parameterMap,
					request, response);

			//ResponseEntity resEntity = ((ResponseEntity<?>) object);

			System.out.println("Response Code::"+responseMessage.getStatusCode());
			int httpStatus= responseMessage.getStatusCode().value();
			System.out.println("http Status::"+httpStatus);

			if(httpStatus==200)
			{

				Type type = new TypeToken<Map<String, Object>>() {
				}.getType();
				Map<String, Object> map = new Gson().fromJson(responseMessage.getBody().toString(), type);
				return  new ResponseEntity<>(map, responseMessage.getStatusCode());
			}
			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** retrieve Order API Execution Ended *******************************************");

			// Returning Response
			return  responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get available offer.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getAvailableOffer(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** get Available Offer API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getAvailableOffer", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************  get Available Offer API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to update device settings on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to update settings
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateDeviceSettings(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** update Device Settings API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateDeviceSettings", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** update Device Settings API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to switch profile.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to switch profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> switchProfile(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** switch Profile API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("switchProfile", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** switch Profile API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to replace hardware.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to replace hardware
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> replaceHardware(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** replace hardware API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("replaceHardware", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** replace hardware API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to update rating profile.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param country_code
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to update rating profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateRatingProfile(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** update Rating Profile API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP+parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateRatingProfile", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** update Rating Profile API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sim list on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim list
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimList(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sim List API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSIMList", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sim List API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sim audit history on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim audit history
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimAuditHistory(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sim Audit History API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimAuditHistory", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sim Audit History API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get data usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sim audit history
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getDataUsage(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Data Usage API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getDataUsage", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Data Usage Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sms usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sms usage
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSmsUsage(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sms Usage API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSmsUsage", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sms Usage Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get voice usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get voice usage
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getVoiceUsage(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Voice Usage API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getVoiceUsage", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Voice Usage Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get rate plans.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getRatePlans(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Rate Plans API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getRatePlans", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Rate Plans Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get rate plans.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getServicePlanList(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Service Plan List API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getServicePlanList", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Service Plan List Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * This API is used to get rate plans.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getServiceCoverageList(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Service Coverage List API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getServiceCoverageList", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Service Coverage List Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	/**
	 * This API is used to get data plans on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get data plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getDataPlans(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Data Plans API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getDataPlans", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Data Plans Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	/**
	 * This API is used to get data plans on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get data plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> echo(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Echo API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("echo", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************Echo Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}




	/**
	 * This API is used to get data plans on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get data plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> retrievePurchases(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** retrievePurchases API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("retrievePurchases", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************retreivePurchases Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * This API is used to Attach Service plan of change service profile on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to attach Service Plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> attachServicePlan(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** Attach Service Plan API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			/***ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("attachServicePlan", parameterMap,
					request, response);

			logger.info("*************************** Attach Service Plan Execution Ended *******************************************");

			// Returning Response
			return responseMessage;*/
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	public ResponseEntity<?> GetExpiredUserPurchasesBatchAPI(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Expired User Purchases Batch API API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("GetExpiredUserPurchasesBatchAPI", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************Get Expired User Purchases Batch Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	public ResponseEntity<?> reverseOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Reverse Order API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("reverseOrder", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************Get Reverse Order Api Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<?> reserveOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Reserve Order(Authorization fund) API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("reserveOrder", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************Reserve Order Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<?> captureFund(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Capture Fund  API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);

			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logAudit.auditLogInsert("log", CALLING_OL_GENERIC_API_EXECUTE_METHOD, parameterMap.toString(), request);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("captureFund", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("***************************Capture Fund Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}




}
