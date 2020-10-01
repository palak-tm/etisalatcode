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
public class GoupB2CService {

	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OperatorInterfaceInfo operatorInterfaceInfo;

	@Autowired
	private AuditServices logAudit;

	/**
	 * This API is used to check user is exists or not on the basis of given
	 * iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to check user existance
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userExistenceCheck(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "userExistenceCheck", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to register user
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to user registration
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userRegistration(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "userRegistration", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to remove user on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to remove user
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userRemoval(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "userRemoval", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to update user on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to update user
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateUser(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "updateUser", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to swap sim of an user.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to sim swap
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userSimSwap(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "userSimSwap", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to user retrieval.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to user retrieval
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> userRetrieval(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "userRetrieval", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to add order.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to add order
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> addOrder(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "addOrder", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to check order.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to check order
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> checkOrder(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "checkOrder", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to cancel order.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to cancel order
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> cancelOrder(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "cancelOrder", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to retrieve order.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to retrieve order
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> retrieveOrder(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "retrieveOrder", paramType, paramValue);

			if (object != null) {
			
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to get available offer.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to get available offer
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getAvailableOffer(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "getAvailableOffer", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to updata the user of Amx Claro
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to get available offer
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateUserAmx(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "updateUserAmx", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	/**
	 * This API is used to updata the user of Amx Claro
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to get available offer
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> buyProductAmx(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "buyProductAmx", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	/**
	 * This API is used to updata the user of Amx Claro
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to get available offer
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> addOrderPgo(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "addOrderPgo", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	public ResponseEntity<?> getExpiredUserPurchasesBatchAPI(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "GetExpiredUserPurchasesBatchAPI", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	/**
	 * This API is used for Change Sim Plan
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to change sim plan
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> changePlan(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "changePlan", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	/**
	 * This API is used for Sim UnProvisioning
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to get available offer
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> simUnprovisioning(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "simUnprovisioning", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	/**
	 * This API is used for Sim Provisioning
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to get available offer
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> simProvisioning(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "simProvisioning", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}


	/**
	 * This API is used for query about plan
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to queryPlanList
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> queryPlanList(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "queryPlanList", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	
	/**
	 * This API is used to change sim.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to changeSim
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> changeSim(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "changeSim", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	
	
	/**
	 * This API is used to reverse order
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to reverse order
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> reverseOrder(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "reverseOrder", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	
	/**
	 * This API is used to authorize fund
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to authorize fund
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> reserveOrder(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "reserveOrder", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	
	/**
	 * This API is used to capture fund
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to capture fund
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> captureFund(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "captureFund", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

}
