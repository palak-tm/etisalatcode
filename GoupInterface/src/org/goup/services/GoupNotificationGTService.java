/**
 * This pacakage contains class related to GOUP APIs service implementation.
 */
package org.goup.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.goup.constant.AsyncConstant;
import org.goup.request.model.Message;
import org.orchestration.resources.JsonOlcoreModification;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class use as Service to call all GOUP Notifications APIs.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-31
 */
@Service
public class GoupNotificationGTService {

	/*
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private GenericMethodService methodService;
	
	//	 instantiate logger
	Logger logger = Logger.getLogger(GoupNotificationGTService.class);

	/**
	 * This Api is used to send Notifications for sim activation.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			HttpServletRequest object
	 * @param response
	 * 			HttpServletResponse object
	 * @return	return the response message
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<?> activateSimNotification(String param, HttpServletRequest request,
			HttpServletResponse response) {
		
		String responseCode = "202";
		try {
			logger.info("************ activate_Sim_Notification API Called.... *********************");
			logger.info("requestBody :-" + param);

			Map<String, String> requestParamMap = new HashMap<>();
			//	converting body parameters into Map
			JsonOlcoreModification.parseOL(param, requestParamMap);

			if (requestParamMap.containsKey("code")) {
				responseCode = requestParamMap.get("code");
			}

			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put("request_id", requestParamMap.get("requestId"));
			inputParamMap.put("iccid", requestParamMap.get("iccid"));
			inputParamMap.put("ban", requestParamMap.get("ban"));
			inputParamMap.put("unique_sim_identifier", requestParamMap.get("unique_sim_identifier"));
			inputParamMap.put("api_group_name", AsyncConstant.GConnectAsyncConstant.ACTIVATE_SIM_API_GROUP);

			//	calling store procedure to get notification url (Always Southbound component url)
			Message result = genericProcess.GenericProcedureCalling("1", inputParamMap, null, request, response);

			if (!result.isValid()) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			List<Map<String, String>> listMap = (List<Map<String, String>>) result.getObject();
			logger.info("Result from DB:-"+listMap);
			

			if (listMap.size() == 0) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			//	adding required parameters in request parameters to sent notification
			requestParamMap.putAll(listMap.get(0));
			logger.info("Final Request Parameters for Notification:-" + requestParamMap);

			//	calling Ol core method to sent Notification in kafka
			ResponseEntity<?> responseMessage = methodService.genericNotificationMethod(
					AsyncConstant.GConnectAsyncConstant.ACTIVATE_SIM_API_GROUP, AsyncConstant.GConnectAsyncConstant.PLATFORM, responseCode, requestParamMap,
					request, response);

			logger.info("**************** Removing Notification url from Database ************************");
			
			//	calling stored procedure to delete notification entry from database
			Message deleteResult = genericProcess.GenericProcedureCalling("3", inputParamMap, null, request, response);
			logger.info("Notification_Record_Removed Response:-" + deleteResult);

			logger.info("*************************** activate_Sim_Notification API Execution Ended *******************************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info("Exception Occured :-" + exception.getMessage());
			exception.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Api is used to send Notifications for sim deactivation.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			HttpServletRequest object
	 * @param response
	 * 			HttpServletResponse object
	 * @return	return the response message
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<?> deactivateSimNotification(String param, HttpServletRequest request,
			HttpServletResponse response) {
		
		String responseCode = "202";
		try {
			logger.info("************ deactivate Sim Notification API Called.... *********************");
			logger.info("requestBody :-" + param);

			Map<String, String> requestParamMap = new HashMap<>();
			//	converting body parameters into Map			
			JsonOlcoreModification.parseOL(param, requestParamMap);

			if (requestParamMap.containsKey("code")) {
				responseCode = requestParamMap.get("code");
			}

			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put("request_id", requestParamMap.get("requestId"));
			inputParamMap.put("iccid", requestParamMap.get("iccid"));
			inputParamMap.put("ban", requestParamMap.get("ban"));
			inputParamMap.put("unique_sim_identifier", requestParamMap.get("unique_sim_identifier"));
			inputParamMap.put("api_group_name", AsyncConstant.GConnectAsyncConstant.DEACTIVATE_SIM_API_GROUP);

			//	calling store procedure to get notification url (Always Southbound component url)
			Message result = genericProcess.GenericProcedureCalling("1", inputParamMap, null, request, response);

			if (!result.isValid()) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			List<Map<String, String>> listMap = (List<Map<String, String>>) result.getObject();
			logger.info("Result from DB:-"+listMap);

			if (listMap.size() == 0) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			//	adding required parameters in request parameters to sent notification
			requestParamMap.putAll(listMap.get(0));
			logger.info("Final Request Parameters for Notification:-" + requestParamMap);

			//	calling Ol core method to sent Notification in kafka
			ResponseEntity<?> responseMessage = methodService.genericNotificationMethod(
					AsyncConstant.GConnectAsyncConstant.DEACTIVATE_SIM_API_GROUP, AsyncConstant.GConnectAsyncConstant.PLATFORM, responseCode, requestParamMap,
					request, response);

			logger.info("**************** Removing Notification url from Database ************************");			
			//	calling stored procedure to delete notification entry from database
			Message deleteResult = genericProcess.GenericProcedureCalling("3", inputParamMap, null, request, response);
			logger.info("Notification_Record_Removed Response:-" + deleteResult);
			
			logger.info("*************************** deactivate Sim Notification API Execution Ended *******************************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info("Exception Occured :-" + exception.getMessage());
			exception.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Api is used to send Notifications for sim suspend activity.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			HttpServletRequest object
	 * @param response
	 * 			HttpServletResponse object
	 * @return	return the response message
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<?> suspendSimNotification(String param, HttpServletRequest request,
			HttpServletResponse response) {
		
		String responseCode = "202";
		try {
			logger.info("************ suspend Sim Notification API Called.... *********************");
			logger.info("requestBody :-" + param);

			Map<String, String> requestParamMap = new HashMap<>();
			//	converting body parameters into Map	
			JsonOlcoreModification.parseOL(param, requestParamMap);

			if (requestParamMap.containsKey("code")) {
				responseCode = requestParamMap.get("code");
			}

			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put("request_id", requestParamMap.get("requestId"));
			inputParamMap.put("iccid", requestParamMap.get("iccid"));
			inputParamMap.put("ban", requestParamMap.get("ban"));
			inputParamMap.put("unique_sim_identifier", requestParamMap.get("unique_sim_identifier"));
			inputParamMap.put("api_group_name", AsyncConstant.GConnectAsyncConstant.SUSPEND_SIM_API_GROUP);

			//	calling store procedure to get notification url (Always Southbound component url)
			Message result = genericProcess.GenericProcedureCalling("1", inputParamMap, null, request, response);

			if (!result.isValid()) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			List<Map<String, String>> listMap = (List<Map<String, String>>) result.getObject();
			logger.info("Result from DB:-"+listMap);

			if (listMap.size() == 0) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			//	adding required parameters in request parameters to sent notification
			requestParamMap.putAll(listMap.get(0));
			logger.info("Final Request Parameters for Notification:-" + requestParamMap);

			//	calling Ol core method to sent Notification in kafka
			ResponseEntity<?> responseMessage = methodService.genericNotificationMethod(
					AsyncConstant.GConnectAsyncConstant.SUSPEND_SIM_API_GROUP, AsyncConstant.GConnectAsyncConstant.PLATFORM, responseCode, requestParamMap,
					request, response);

			logger.info("**************** Removing Notification Url from Database ************************");
			//	calling stored procedure to delete notification entry from database
			Message deleteResult = genericProcess.GenericProcedureCalling("3", inputParamMap, null, request, response);
			logger.info("Notification_Record_Removed Response:-" + deleteResult);
			
			logger.info("*************************** suspend Sim Notification API Execution Ended *******************************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info("Exception Occured :-" + exception.getMessage());
			exception.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Api is used to send Notifications for sim reactivation.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			HttpServletRequest object
	 * @param response
	 * 			HttpServletResponse object
	 * @return	return the response message
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<?> reactivateSimNotification(String param, HttpServletRequest request,
			HttpServletResponse response) {
	
		String responseCode = "202";
		try {
			logger.info("************ reactivate Sim Notification API Called.... *********************");
			logger.info("requestBody :-" + param);

			Map<String, String> requestParamMap = new HashMap<>();
			//	converting body parameters into Map	
			JsonOlcoreModification.parseOL(param, requestParamMap);

			if (requestParamMap.containsKey("code")) {
				responseCode = requestParamMap.get("code");
			}

			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put("request_id", requestParamMap.get("requestId"));
			inputParamMap.put("iccid", requestParamMap.get("iccid"));
			inputParamMap.put("ban", requestParamMap.get("ban"));
			inputParamMap.put("unique_sim_identifier", requestParamMap.get("unique_sim_identifier"));
			inputParamMap.put("api_group_name", AsyncConstant.GConnectAsyncConstant.REACTIVATE_SIM_API_GROUP);

			//	calling store procedure to get notification url (Always Southbound component url)
			Message result = genericProcess.GenericProcedureCalling("1", inputParamMap, null, request, response);

			if (!result.isValid()) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			List<Map<String, String>> listMap = (List<Map<String, String>>) result.getObject();
			logger.info("Result from DB:-"+listMap);

			if (listMap.size() == 0) {
				new ResponseEntity<>("Invalid Request.", HttpStatus.NOT_ACCEPTABLE);
			}

			//	adding required parameters in request parameters to sent notification
			requestParamMap.putAll(listMap.get(0));
			logger.info("Final Request Parameters for Notification:-" + requestParamMap);

			//	calling Ol core method to sent Notification in kafka
			ResponseEntity<?> responseMessage = methodService.genericNotificationMethod(
					AsyncConstant.GConnectAsyncConstant.REACTIVATE_SIM_API_GROUP, AsyncConstant.GConnectAsyncConstant.PLATFORM, responseCode, requestParamMap,
					request, response);

			logger.info("**************** Removing Notification Url from Database ************************");
			//	calling stored procedure to delete notification entry from database
			Message deleteResult = genericProcess.GenericProcedureCalling("3", inputParamMap, null, request, response);
			logger.info("Notification_Record_Removed Response:-" + deleteResult);

			logger.info("*************************** reactivate Sim Notification API Execution Ended *******************************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info("Exception Occured :-" + exception.getMessage());
			exception.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
