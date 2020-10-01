/**
 * This package contains classes related to operators interface api implementation.
 */
package org.goup.mno.interface_implementation;

/**
 * To Import Classes to access their functionality
 */
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.goup.services.AuditServices;
import org.goup.services.GenericProcess;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * This class use as component to execute all api calls related to Jasper Platform.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-03
 */
@Component
public class JasperInterface {
	
	private static final String COUNTRY_CODE = "country_code";
	private static final String OPERATOR_NAME = "operator_name";
	private static final String API_INPUT_PARAMETER_MAP = "api input parameterMap : ";
	private static final String EXCEPTION_OCCURED = "Exception occured :-";
	private static final String CALLING_OL_GENERIC_API_EXECUTE_METHOD = "calling to GOUP OL Core genericExecuteApiMethod";
	private static final String RESPONSE_OL_GENERIC_API_EXECUTE_METHOD = "response from GOUP OL Core genericExecuteApiMethod";
	
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
	 * instantiate logger object
	 */
	Logger logger = Logger.getLogger(JasperInterface.class);

	/**
	 * This API is used to get sim details on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
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
			logger.info("*************************** Get Sim Details API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to get sim data usage info on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
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
			logger.info("*************************** Get Sim Usage API Execution Ended ****************************");

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
	 * @param countryCode
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
			logger.info("********************************** Sim Session Info API called ***********************************");

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
			logger.info("*************************** Sim Session Info API Execution Ended *******************************************");

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
	 * @param countryCode
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

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** activate sim API called ***********************************");

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
			logger.info("*************************** activate sim API Execution Ended *******************************************");

			// Returning Response
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
	 * @param countryCode
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

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** deactivate sim API called ***********************************");

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
			logger.info("*************************** deactivate sim API Execution Ended *******************************************");

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
	 * @param countryCode
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

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** suspend sim API called ***********************************");

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
			logger.info("*************************** suspend sim API Execution Ended *******************************************");

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
	 * @param countryCode
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

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** reactivate sim API called ***********************************");

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
			logger.info("*************************** reactivate sim API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to echo resource on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to echo resource
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> echo(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** echo API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("echo", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** echo API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to update rate plan on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to update Rate plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateRatePlan(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Update Rate Plan API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateRatePlan", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Update Rate Plan API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to update communication plan on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to update Communication Plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateCommunicationPlan(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Update Communication Plan API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateCommunicationPlan", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Update Communication Plan API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to get sms details on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get sms details
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSmsDetails(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Get Sms Details API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSmsDetails", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Get Sms Details API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to send sms on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to send sms
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> sendSms(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null || logAudit == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
			logAudit = webApplicationContext.getBean(AuditServices.class);
		}
		try {
			logger.info("********************************** Send Sms API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("sendSms", parameterMap,
					request, response);

			logAudit.auditLogInsert("log", RESPONSE_OL_GENERIC_API_EXECUTE_METHOD, responseMessage.toString(), request);
			logger.info("*************************** Send Sms API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED+exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
