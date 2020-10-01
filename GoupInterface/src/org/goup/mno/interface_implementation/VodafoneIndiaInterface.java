/**
 * This package contains classes related to operators interface api implementation.
 */
package org.goup.mno.interface_implementation;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.goup.request.model.DeviceHistoryList.DeviceHistoryItem;
import org.goup.services.AuditServices;
import org.goup.services.GenericProcess;
import org.goup.swagger.response.DataUsage;
import org.goup.swagger.response.DataUsage.DataUsageParameter;
import org.goup.swagger.response.Error;
import org.goup.swagger.response.GetSimAuditHistory;
import org.goup.swagger.response.GetSimUsage;
import org.goup.swagger.response.GetSimUsage.UserSimDetails;
import org.goup.swagger.response.SimDetails;
import org.goup.swagger.response.GetSimAuditHistory.userSessionLogs;
import org.goup.swagger.response.GetSimAuditHistory.userSessionLogs.sessionLogs;
import org.orchestration.resources.JsonOlcoreModification;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;


/**
 * This class use as component to execute all api calls related to Comarch Platform.
 * 
 * @author	Aman Agarwal
 * @version	1.0
 * @since	2018-11-29
 */
@Component
public class VodafoneIndiaInterface {
	
	private static final String COUNTRY_CODE = "country_code";
	private static final String OPERATOR_NAME = "operator_name";
	private static final String API_INPUT_PARAMETER_MAP = "api input parameterMap : ";
	private static final String EXCEPTION_OCCURED = "Exception occured :-";
	private static final String DOWNSTREAM_ERROR_MESSAGE="Downstream System Error: [<errorCode>]: [<errorMessage>]";
	
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

			int httpStatus= responseMessage.getStatusCode().value();
			SimDetails simDetails = new SimDetails();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			
			
			if(httpStatus==200)
			{
				
				
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
					

					/**System.out.println(map.get("deviceInformationList").getClass().getName());
					ObjectMapper mapper = new ObjectMapper();
					
					@SuppressWarnings("unchecked")
					Map<String, Object> deviceInformationListMap = mapper.convertValue( map.get("deviceInformationList"), Map.class);
					ArrayList<?> list = (ArrayList<?>) deviceInformationListMap.get("deviceInformationItem");
					
					Map<String,Object> intermediateResponseMap= new LinkedHashMap<>();

					for(int i=0;i<list.size();i++)
					{

						@SuppressWarnings("unchecked")
						Map<String, Object> mapItems = (Map<String, Object>) list.get(i);
						String itemName=(String) mapItems.get("itemName");
						Object itemValue="";
						if(mapItems.containsKey("itemValue"))
						{
						 
							 itemValue=mapItems.get("itemValue");
						}
						
						intermediateResponseMap.put(itemName,itemValue);
						
					}*/
					simDetails.setIccid(parameterMap.get("iccid").toString());
					simDetails.setImsi(parameterMap.get("imsi"));
					simDetails.setMsisdn(parameterMap.get("msidn"));
					simDetails.setSimStatus(map.get("state").toString());
					return  new ResponseEntity<>(simDetails, responseMessage.getStatusCode());
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
		
			System.out.println(responseMessage);
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
			
			int httpStatus= responseMessage.getStatusCode().value();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			if(httpStatus==200)
			{
				
				
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
		
					return  new ResponseEntity<>("{}", HttpStatus.ACCEPTED);
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}

			
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

			int httpStatus= responseMessage.getStatusCode().value();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			if(httpStatus==200)
			{
				
				
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
		
					return  new ResponseEntity<>("{}", HttpStatus.ACCEPTED);
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
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
			int httpStatus= responseMessage.getStatusCode().value();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			if(httpStatus==200)
			{
				
				
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
		
					String reportBody= map.get("reportBody").toString();
					return  new ResponseEntity<>("{}", HttpStatus.ACCEPTED);
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
			
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

			
			int httpStatus= responseMessage.getStatusCode().value();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			if(httpStatus==200)
			{
				
				GetSimUsage getSimUsage= new GetSimUsage();
				List<UserSimDetails> userData=new ArrayList<>();
				UserSimDetails userSimDetails= new UserSimDetails();
				userSimDetails.setImsi(parameterMap.get("imsi"));
				userSimDetails.setIccid(parameterMap.get("iccid"));
				userSimDetails.setMsisdn(parameterMap.get("msisdn"));
				
				
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
		
					String reportBody= map.get("reportBody").toString();
					byte[] byteArray = Base64.decodeBase64(reportBody);
				    String decodedString = new String(byteArray);
				    String[] lines = decodedString.split("\n");
					List<String> listOfLines = Arrays.asList(lines);
                    String requiredData= null;
                    /**Getting the Data Usage of iccid passed in Request**/
					for(int index=0;index<listOfLines.size();index++)
					{
						String row = listOfLines.get(index);
						/** To check row contains SECTION string */
						if (row.contains("Packet Data Usage") && row.contains(parameterMap.get("iccid").trim())) {
							requiredData=row;
							break;
						}
					}
					
					/**Check Required Data is not null*/
					if(requiredData!=null )
					{
						List<String> dataUsageRow=Arrays.asList(requiredData.split(","));
						if(dataUsageRow.size()>8)
						{
							String totalKbps= dataUsageRow.get(8);
							userSimDetails.setVolume(totalKbps);
						}
						
						
					}
					
					userData.add(userSimDetails);
				    getSimUsage.setUserData(userData);
				    
					return  new ResponseEntity<>(getSimUsage, HttpStatus.ACCEPTED);
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
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
			
			int httpStatus= responseMessage.getStatusCode().value();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			if(httpStatus==200)
			{
				GetSimAuditHistory getSimAuditHistory= new GetSimAuditHistory();
				userSessionLogs useRSessionLogs= new userSessionLogs();
				
				
				List<userSessionLogs> userSessionLogs= new ArrayList<>();
				List<sessionLogs> listOfSessionLogs = new ArrayList<>();
				
				
				
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
					Type listType = new TypeToken<Map<String, Object>>() {
					}.getType();
		
					Map<String, Object> l= new Gson().fromJson(map.get("deviceHistoryList").toString(), listType);
					@SuppressWarnings("unchecked")
					List<DeviceHistoryItem> deviceHistoryItem= (List<DeviceHistoryItem>) l.get("deviceHistoryItem");
					
					for(int i=0;i<deviceHistoryItem.size();i++)
					{
						Map<String, String> item = (Map<String, String>) deviceHistoryItem.get(i);
						sessionLogs sessionLOgs= new sessionLogs();
						sessionLOgs.setIccid(parameterMap.get("iccid"));
						sessionLOgs.setImsi(parameterMap.get("imsi"));
						sessionLOgs.setMsisdn(parameterMap.get("msisdn"));
						sessionLOgs.setChange(item.get("state")+ " to " +item.get("operation"));
						sessionLOgs.setDate(item.get("timestamp"));
						sessionLOgs.setChangeSource("Manual Action");
						sessionLOgs.setTriggeredBy("");
						sessionLOgs.setStatus("Finished");
						listOfSessionLogs.add(sessionLOgs);
					
					}
					useRSessionLogs.setSessionLogs(listOfSessionLogs);
					useRSessionLogs.setSize(deviceHistoryItem.size());
					userSessionLogs.add(useRSessionLogs);
					getSimAuditHistory.setUserSessionLogs(userSessionLogs);
					return  new ResponseEntity<>(getSimAuditHistory, HttpStatus.OK);
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}

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

			int httpStatus= responseMessage.getStatusCode().value();
			Error error= new Error();
			Error.ErrorMessage errorMessage=new Error.ErrorMessage();
			if(httpStatus==200)
			{
		
				Map<String, Object> map = new LinkedHashMap<>();
				map=JsonOlcoreModification.parseOLObject(responseMessage.getBody().toString(), map);
				/** Response Will be Successful if  major return code is 000 and minor Return Code is 0000. Otherwise Send Error As CMN004**/
				if(map.get("majorReturnCode").toString().trim().equals("000") && map.get("minorReturnCode").toString().trim().equals("0000"))
				{
		
					String reportBody= map.get("reportBody").toString();
					byte[] byteArray = Base64.decodeBase64(reportBody);
				    String decodedString = new String(byteArray);
				    String[] lines = decodedString.split("\n");
					List<String> listOfLines = Arrays.asList(lines);
                    int dataIndex=0;
                    /**Getting the Data Usage of iccid passed in Request**/
					for(int index=0;index<listOfLines.size();index++)
					{
					
						String row= listOfLines.get(index);
						if(row.contains("SECTION,Data,-1"))
						{
							dataIndex=index+1;
							break;
						}
					}
					
				 List<String> dataList= listOfLines.subList(dataIndex, listOfLines.size()-2);
				 

				 List<DataUsageParameter> dataUsageList= new ArrayList<>();
				 DataUsage dataUsage= new DataUsage();
				 
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 
				 
				 for(int x=0;x<dataList.size();x++)
				 {
					 int totalBytes=0;
					 DataUsage.DataUsageParameter dataUsageParameters= new DataUsage.DataUsageParameter();
					 String byetsInput= Arrays.asList(dataList.get(x).split(",")).get(6);
					 String bytesOutput= Arrays.asList(dataList.get(x).split(",")).get(7);
					 dataUsageParameters.setSessionStartDate(Arrays.asList(dataList.get(x).split(",")).get(4));
					 dataUsageParameters.setSessionEndDate(Arrays.asList(dataList.get(x).split(",")).get(5));
					 totalBytes= totalBytes+Integer.parseInt(byetsInput)+Integer.parseInt(bytesOutput);
					 dataUsageParameters.setIccid(parameterMap.get("iccid"));
					 dataUsageParameters.setImsi(parameterMap.get("imsi"));
					 dataUsageParameters.setMsisdn(parameterMap.get("msisdn"));
					 dataUsageParameters.setDataUsage(String.valueOf(totalBytes));
					 
					 java.util.Date startDate= sdf.parse(Arrays.asList(dataList.get(x).split(",")).get(4));
					 java.util.Date endDate= sdf.parse(Arrays.asList(dataList.get(x).split(",")).get(5));
					 long duration  = endDate.getTime() - startDate.getTime();
					 String diffInHours = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration),
					            TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)),
					            TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
					 
					 
					 dataUsageParameters.setDuration(String.valueOf(diffInHours));
					 
					 
					 dataUsageList.add(dataUsageParameters);
					
					
					 
				 }
				 
				 dataUsage.setDataUsageParameters(dataUsageList);
			     return  new ResponseEntity<>(dataUsage, HttpStatus.ACCEPTED);
				}
				
				else
				{
					errorMessage.setCode("CMN004");
					errorMessage.setDescription(DOWNSTREAM_ERROR_MESSAGE.replaceAll
							("errorCode",map.get("majorReturnCode").toString().trim()).replaceAll("errorMessage", "Minor Return Code is:"+map.get("majorReturnCode").toString().trim()));
					error.setErrors(errorMessage);
					return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
			
			
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
	
}
