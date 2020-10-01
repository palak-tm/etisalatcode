/**
 * This package contains classes related to operators interface api implementation.
 */
package org.goup.mno.interface_implementation;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.goup.services.GenericProcess;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * To Import Classes to access their functionality
 */
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * This class use as component to execute all api calls related to Comarch Platform.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-11-29
 */
@Component
public class ComarchInterface {
	
	private static final String COUNTRY_CODE = "country_code";
	private static final String OPERATOR_NAME = "operator_name";
	private static final String API_INPUT_PARAMETER_MAP = "api input parameterMap : ";
	private static final String EXCEPTION_OCCURED = "Exception occured :-";
	
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * instantiate logger object
	 */
	Logger logger = Logger.getLogger(ComarchInterface.class);
	
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

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimDetails", parameterMap,
					request, response);

			logger.info("*************************** Get Sim Details API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
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

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("activateSim", parameterMap,
					request, response);
			
			logger.info("********************** activate Sim API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
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

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("suspendSim", parameterMap,
					request, response);

			logger.info("********************** suspend Sim API Execution Ended ******************************");
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
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

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("reactivateSim", parameterMap,
					request, response);
			
			
			logger.info("********************** reactivate Sim API Execution Ended ******************************");
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to get sim data usage on the basis of given iccid/imsi.
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

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimUsage", parameterMap,
					request, response);

			logger.info("*************************** Get Sim Usage API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
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

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("simSessionInfo", parameterMap,
					request, response);

			logger.info("*************************** Get Sim Session API Execution Ended *******************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
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

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
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
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("sendSms", parameterMap,
					request, response);

			logger.info("*************************** Send Sms API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
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
			
			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSIMList", parameterMap,
					request, response);

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
			
			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimAuditHistory", parameterMap,
					request, response);

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
			
			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getDataUsage", parameterMap,
					request, response);

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
			
			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSmsUsage", parameterMap,
					request, response);

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
	 * This API is used to disconnect sessions on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to disconnect sessions
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> disconnectSessions(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** Disconnect Sessions API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("disconnectSessions", parameterMap,
					request, response);

			logger.info("*************************** Disconnect Sessions API Execution Ended ********************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to get Invoice on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get Invoice
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getInvoice(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** Get Invoice API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getInvoice", parameterMap,
					request, response);

			logger.info("*************************** Get Invoice Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This API is used to get Invoice on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to get Invoice
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
			
			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getVoiceUsage", parameterMap,
					request, response);

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("attachServicePlan", parameterMap,
					request, response);

			logger.info("*************************** Attach Service Plan Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
