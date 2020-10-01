/**
 * This pacakage contains class related to GOUP APIs service implementation.
 */
package org.goup.services;

import java.lang.reflect.Type;
import java.util.Enumeration;
/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.constant.Constant;
import org.goup.constant.OperatorInterfaceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * This class use as Service to call all GOUP B2C APIs.
 * 
 * @author Sanjay Kumar
 * @version 1.0
 * @since 2018-08-03
 */
@Service
@SuppressWarnings("rawtypes")


public class GoupEsimService {

	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OperatorInterfaceInfo operatorInterfaceInfo;

	@Autowired
	private AuditServices logAudit;

	/**
	 * This API is used to download Profile on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to downloadProfileEsim
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> downloadProfileEsim(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		String country_code = request.getHeader("country_code");
		String operator = request.getHeader("operator");

		String className = (String) operatorInterfaceInfo.getMaps().get("/" + operator + "-" + country_code);

		if (className == null) {
			// adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement();
				parameterMap.put(paramName, request.getHeader(paramName));
			}

			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.",
					parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.", HttpStatus.EXPECTATION_FAILED);
		}

		Class paramType[] = { Map.class, String.class, String.class, HttpServletRequest.class,
				HttpServletResponse.class };
		Object paramValue[] = { parameterMap, country_code, operator, request, response };

		try {
			Object object = Constant.executeMethods(className, "downloadProfileEsim", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	/**
	 * This API is used to enable Profile on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to enableProfileEsim
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> enableProfileEsim(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		String country_code = request.getHeader("country_code");
		String operator = request.getHeader("operator");

		String className = (String) operatorInterfaceInfo.getMaps().get("/" + operator + "-" + country_code);

		if (className == null) {
			// adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement();
				parameterMap.put(paramName, request.getHeader(paramName));
			}

			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.",
					parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.", HttpStatus.EXPECTATION_FAILED);
		}

		Class paramType[] = { Map.class, String.class, String.class, HttpServletRequest.class,
				HttpServletResponse.class };
		Object paramValue[] = { parameterMap, country_code, operator, request, response };

		try {
			Object object = Constant.executeMethods(className, "enableProfileEsim", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	
	/**
	 * This API is used to delete Profile on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to deleteProfileEsim
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> deleteProfileEsim(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		String country_code = request.getHeader("country_code");
		String operator = request.getHeader("operator");

		String className = (String) operatorInterfaceInfo.getMaps().get("/" + operator + "-" + country_code);

		if (className == null) {
			// adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement();
				parameterMap.put(paramName, request.getHeader(paramName));
			}

			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.",
					parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.", HttpStatus.EXPECTATION_FAILED);
		}

		Class paramType[] = { Map.class, String.class, String.class, HttpServletRequest.class,
				HttpServletResponse.class };
		Object paramValue[] = { parameterMap, country_code, operator, request, response };

		try {
			Object object = Constant.executeMethods(className, "deleteProfileEsim", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	
	/**
	 * This API is used to disable Profile on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to disableProfileEsim
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> disableProfileEsim(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		String country_code = request.getHeader("country_code");
		String operator = request.getHeader("operator");

		String className = (String) operatorInterfaceInfo.getMaps().get("/" + operator + "-" + country_code);

		if (className == null) {
			// adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement();
				parameterMap.put(paramName, request.getHeader(paramName));
			}

			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.",
					parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.", HttpStatus.EXPECTATION_FAILED);
		}

		Class paramType[] = { Map.class, String.class, String.class, HttpServletRequest.class,
				HttpServletResponse.class };
		Object paramValue[] = { parameterMap, country_code, operator, request, response };

		try {
			Object object = Constant.executeMethods(className, "disableProfileEsim", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	
	/**
	 * This API is used to set fall back attribute on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to set Fallback Attribute
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> setFallbackAttribute(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		String country_code = request.getHeader("country_code");
		String operator = request.getHeader("operator");

		String className = (String) operatorInterfaceInfo.getMaps().get("/" + operator + "-" + country_code);

		if (className == null) {
			// adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement();
				parameterMap.put(paramName, request.getHeader(paramName));
			}

			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.",
					parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.", HttpStatus.EXPECTATION_FAILED);
		}

		Class paramType[] = { Map.class, String.class, String.class, HttpServletRequest.class,
				HttpServletResponse.class };
		Object paramValue[] = { parameterMap, country_code, operator, request, response };

		try {
			Object object = Constant.executeMethods(className, "setFallbackAttribute", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	/**
	 * This API is used to update Subscription Address on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to update Subscription Address
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateSubscriptionAddress(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		String country_code = request.getHeader("country_code");
		String operator = request.getHeader("operator");

		String className = (String) operatorInterfaceInfo.getMaps().get("/" + operator + "-" + country_code);

		if (className == null) {
			// adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement();
				parameterMap.put(paramName, request.getHeader(paramName));
			}

			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.",
					parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.", HttpStatus.EXPECTATION_FAILED);
		}

		Class paramType[] = { Map.class, String.class, String.class, HttpServletRequest.class,
				HttpServletResponse.class };
		Object paramValue[] = { parameterMap, country_code, operator, request, response };

		try {
			Object object = Constant.executeMethods(className, "updateSubscriptionAddress", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
}
