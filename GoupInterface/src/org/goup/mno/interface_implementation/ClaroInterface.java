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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ClaroInterface {


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
	Logger logger = Logger.getLogger(ClaroInterface.class);
	
	
	/**
	 * This API is used to update user Amx details on the basis of given iccid/imsi.
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
	public ResponseEntity<?> updateUser(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** Update User API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateUser", parameterMap,
					request, response);

			logger.info("***************************Update User API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	/**
	 * This API is used to add order on the basis of given iccid/imsi.
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
	public ResponseEntity<?> addOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** addOrder Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("addOrder", parameterMap,
					request, response);

			logger.info("***************************addOrder API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to update user Amx details on the basis of given iccid/imsi.
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
	public ResponseEntity<?> addOrderPgo(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** addOrderPgo Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("addOrderPgo", parameterMap,
					request, response);

			logger.info("***************************addOrderPgo API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This API is used to cancel order at given iccid/imsi.
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
	public ResponseEntity<?> cancelOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** cancelOrder Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("cancelOrder", parameterMap,
					request, response);

			logger.info("***************************cancelOrder API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	/**
	 * This API is used to check if order exists or not on basis of order id.
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
	public ResponseEntity<?> checkOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** checkOrder Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("checkOrder", parameterMap,
					request, response);

			logger.info("***************************checkOrder API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This API is used to retrieve order on basis of order id .
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
	public ResponseEntity<?> retrieveOrder(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** retrieveOrder Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("retrieveOrder", parameterMap,
					request, response);

			logger.info("***************************retrieveOrder API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to remove user from AMX.
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
	public ResponseEntity<?> userRemoval(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** userRemoval Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userRemoval", parameterMap,
					request, response);

			logger.info("***************************retrieveOrder API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	/**
	 * This API is used to Register an user under AMX IOT hub.
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
	public ResponseEntity<?> userRegistration(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** userRegistration Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userRegistration", parameterMap,
					request, response);

			logger.info("***************************userRegistration API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	
	/**
	 * This API is used to retrieve user information on basis of iccid/imsi/userIdentifier.
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
	public ResponseEntity<?> userRetrieval(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** userRetrieval Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("userRetrieval", parameterMap,
					request, response);

			logger.info("***************************userRegistration API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * This API is used to get Available on a particular IOT HUB country wise.
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
	public ResponseEntity<?> getAvailableOffer(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** getAvailableOffer Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getAvailableOffer", parameterMap,
					request, response);

			logger.info("***************************getAvailableOffer API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * This API is used to get Available on a particular IOT HUB country wise.
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
	public ResponseEntity<?> simProvisioning(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** simProvisioning Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("simProvisioning", parameterMap,
					request, response);

			logger.info("***************************simProvisioning API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

/**
	 
	 * This API is used to get Available on a particular IOT HUB country wise.
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
	public ResponseEntity<?> simUnprovisioning(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** simUnprovisioning Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("simUnprovisioning", parameterMap,
					request, response);

			logger.info("***************************simUnprovisioning API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	 /**
	 
	 * This API is used to change plan on a particular IOT HUB country wise.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to change plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> changePlan(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** changePlan Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("changePlan", parameterMap,
					request, response);

			logger.info("***************************changePlan API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * This API is used to setFallbackAttribute on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to set fall back attributes.
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> setFallbackAttribute(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** setFallbackAttribute Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("setFallbackAttribute", parameterMap,
					request, response);

			logger.info("***************************setFallbackAttribute API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	
	
	/**
	 * This API is used to disable profile on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to disable profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> disableProfileEsim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** disableProfileEsim Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("disableProfileEsim", parameterMap,
					request, response);

			logger.info("***************************disableProfileEsim API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	
	/**
	 * This API is used to download profile on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to  download profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> downloadProfileEsim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** downloadProfileEsim Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("downloadProfileEsim", parameterMap,
					request, response);

			logger.info("***************************downloadProfileEsim API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	
	/**
	 * This API is used to enable profile on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to enable profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> enableProfileEsim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** enableProfileEsim Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("enableProfileEsim", parameterMap,
					request, response);

			logger.info("***************************enableProfileEsim API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	
	/**
	 * This API is used to delete profile on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to delete profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> deleteProfileEsim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** deleteProfileEsim Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("deleteProfileEsim", parameterMap,
					request, response);

			logger.info("***************************deleteProfileEsim API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	/**
	 * This API is used to update Subscription Address on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to updateSubscriptionAddress
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateSubscriptionAddress(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** updateSubscriptionAddress Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("updateSubscriptionAddress", parameterMap,
					request, response);

			logger.info("***************************updateSubscriptionAddress API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This API is used to queryPlanList on basis of iccid.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to queryPlanList
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> queryPlanList(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** queryPlanList Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("queryPlanList", parameterMap,
					request, response);

			logger.info("***************************queryPlanList API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to changeSim 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to changeSim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> changeSim(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		try {
			logger.info("********************************** changeSim Amx API called ***********************************");

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
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("changeSim", parameterMap,
					request, response);

			logger.info("***************************changeSim API Execution Ended *******************************************");
			
			// Returning Response
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
