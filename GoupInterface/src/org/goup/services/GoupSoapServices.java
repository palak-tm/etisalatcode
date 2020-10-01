package org.goup.services;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.constant.Constant;
import org.goup.constant.OperatorInterfaceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class use as Service to call all GOUP B2B APIs.
 * 
 * @author	Aman Agarwal
 * @version	1.0
 * @since	2019-11-01
 */
@Service
@SuppressWarnings("rawtypes")

public class GoupSoapServices {
	
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OperatorInterfaceInfo operatorInterfaceInfo;	
	
	@Autowired
	private AuditServices logAudit;
	
	public ResponseEntity<?> OEMOrderRequest(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "OEMOrderRequest", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	
	public ResponseEntity<?> notifyOEM(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "notifyOEM", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}



	
	public ResponseEntity<?> ES2_HandleProfileDeletedNotification(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "ES2_HandleProfileDeletedNotification", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	
	public ResponseEntity<?> ES2_HandleProfileDisabledNotification(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "ES2_HandleProfileDisabledNotification", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	

	public ResponseEntity<?> ES2_HandleProfileEnabledNotification(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "ES2_HandleProfileEnabledNotification", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	
	public ResponseEntity<?> DownloadProfileCallback(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "DownloadProfileCallback", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	public ResponseEntity<?> EnableProfileCallback(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "EnableProfileCallback", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}



	public ResponseEntity<?> DisableProfileCallback(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "DisableProfileCallback", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	public ResponseEntity<?> DeleteProfileCallback(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "DeleteProfileCallback", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}



}
