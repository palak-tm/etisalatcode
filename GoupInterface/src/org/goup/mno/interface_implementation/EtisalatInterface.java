/**
 * This package contains classes related to operators interface api implementation.
 */
package org.goup.mno.interface_implementation;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.goup.constant.AsyncConstant;
import org.goup.request.model.Message;
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
 * @author	AmanAgarwal
 * @version	1.0
 * @since	2019-11-08
 */
@Component
public class EtisalatInterface {
	
	private static final String COUNTRY_CODE = "country_code";
	private static final String OPERATOR_NAME = "operator_name";
	private static final String API_INPUT_PARAMETER_MAP = "api input parameterMap : ";
	private static final String EXCEPTION_OCCURED = "Exception occured :-";
	private static final String REQUEST_ID = "request_id";
	private static final String ICCID = "iccid";
	private static final String BAN = "ban";
	private static final String UNIQUE_SIM_IDENTIFIER = "unique_sim_identifier";
	private static final String API_GROUP_NAME = "api_group_name";
	private static final String RETURN_URL = "returnUrl";
	private static final String NOTIFICATION_URL = "returnurl";
	private static final String CALLING_OL_GENERIC_API_EXECUTE_METHOD = "calling to GOUP OL Core genericExecuteApiMethod";
	private static final String RESPONSE_OL_GENERIC_API_EXECUTE_METHOD = "response from GOUP OL Core genericExecuteApiMethod";
	private static final String RESPONSE_CODE_FROM_OL="response code from OL_Core:-";
	private static final String RESPONSE_FROM_OL="response from OL core:-";
	private static final String RESPONSE_BODY_FROM_OL="response body from OL core:-";
	private static final String DATA_INSERTING_IN_NOTIFICATION_QUEUE="Data Inserting In Nofication Queue...";
	private static final String DATA_INSERTED_IN_NOTIFICATION_QUEUE="Data Inserted In Nofication Queue Successfully..";
	private static final String RETURN_URL_INSERTED_LOG="return url inserted into thirdparty database";
	private static final String NOTIFICATION_INSERT_PROCEDURE_RESULT= "Notification Insert Procedure Result:-";
	private static final String THIRD_PARTY_RETURN_URL= "thirdPartyReturnUrl";
	
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	
	@Autowired(required = true)
	private GenericProcess genericProcess;

	/**
	 * instantiate logger object
	 */
	Logger logger = Logger.getLogger(EtisalatInterface.class);
	
	/**
	 * This API is used to OEMOrderRequest on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to OEMOrderRequest
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> OEMOrderRequest(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("********************************** OEMOrderRequest API called ***********************************");

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
			
			logger.info(DATA_INSERTING_IN_NOTIFICATION_QUEUE);
			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put(REQUEST_ID, request.getHeader(REQUEST_ID));
			inputParamMap.put(ICCID, request.getHeader(ICCID));
			inputParamMap.put(BAN, "");
			inputParamMap.put(UNIQUE_SIM_IDENTIFIER,"");
			inputParamMap.put(API_GROUP_NAME, "OEMOrderRequest");			
			inputParamMap.put(RETURN_URL, request.getHeader(NOTIFICATION_URL));
			inputParamMap.put(COUNTRY_CODE, countryCode);
			inputParamMap.put(OPERATOR_NAME, operator);			

			Message result = genericProcess.GenericProcedureCalling("2", inputParamMap, null, request, response);
			logger.info(NOTIFICATION_INSERT_PROCEDURE_RESULT+result);			
			logger.info(DATA_INSERTED_IN_NOTIFICATION_QUEUE);
			
			

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("OEMOrderRequest", parameterMap,
					request, response);
			System.out.println("Oem order response in etisalat interface :-"  +responseMessage);
			logger.info("********************** OEMOrderRequest API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This API is used to notifyOEM on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to notifyOEM
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> notifyOEM(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************notifyOEM API called ***********************************");

			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			
			parameterMap.put("ResponseData", "ResponseData");
			parameterMap.put("ReasonCode", "ReasonCode");
			parameterMap.put("ReasonDescription", "ReasonDescription");
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			logger.info(API_INPUT_PARAMETER_MAP + parameterMap);
			logger.info("Fetching return url from third party Database");
			Map<String, String> inputParamMap = new LinkedHashMap<>();
			inputParamMap.put(REQUEST_ID, parameterMap.get(REQUEST_ID));
			Message result = genericProcess.GenericProcedureCalling("5", inputParamMap, null, request, response);
			List<Map<String, String>> list = (List<Map<String, String>>) result.getObject();
			
			if(!list.isEmpty())
			{
				Map<String,String> responseMap= list.get(0);
				parameterMap.put(THIRD_PARTY_RETURN_URL, responseMap.get(RETURN_URL));
				
				// Calling OL Core genericExecuteApiMethod Method to execute the API
				
				
			}

			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("notifyOEM", parameterMap,
					request, response);
			logger.info("********************** notifyOEM API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API is used to Notify Esim About the deletion of Profile.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to notifyOEM
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> ES2_HandleProfileDeletedNotification(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************ES2_HandleProfileDeletedNotification API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("ES2_HandleProfileDeletedNotification", parameterMap,
					request, response);
			logger.info("********************** ES2_HandleProfileDeletedNotification API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	/**
	 * This API is used to Notify Esim About the Disabling the Profile on basis of iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to notifyOEM
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> ES2_HandleProfileDisabledNotification(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************ES2_HandleProfileDisabledNotification API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("ES2_HandleProfileDisabledNotification", parameterMap,
					request, response);
			logger.info("********************** ES2_HandleProfileDisabledNotification API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/**
	 * This API is used to Notify Esim About the Enabling the Profile on basis of iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to notifyOEM
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> ES2_HandleProfileEnabledNotification(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************ES2_HandleProfileEnabledNotification API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("ES2_HandleProfileEnabledNotification", parameterMap,
					request, response);
			logger.info("********************** ES2_HandleProfileEnabledNotification API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/**
	 * This API is used to Notify Esim About the Enabling the Profile on basis of iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param countryCode
	 * 			String value represents country code
	 * @param operator
	 * 			String value represents operator name
	 * @param request
	 * 			incoming request to notifyOEM
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> DownloadProfileCallback(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************DownloadProfileCallback API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			String responseSuccessTemplate="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:add=\"http://www.w3.org/2005/08/addressing\" xmlns:ns=\"http://namespaces.gsma.org/esim-messaging/3\">\n" + 
					"   <soap:Header>\n" + 
					"      <RelatesTo RelationshipType=\"http://www.w3.org/2005/08/addressing/reply\">@@RelatesTo@@</RelatesTo>\n" + 
					"      <Action>@@Action@@</Action>\n" + 
					"      <MessageID>@@MessageID@@</MessageID>\n" + 
					"      <To>@@To@@</To>\n" + 
					"   </soap:Header>\n" + 
					"  <soap:Body>\n" + 
					"      <rps:ES2-DownloadProfileResponse>\n" + 
					"         <rps:ProcessingStart>@@ProcessingStart@@</rps:ProcessingStart>\n" + 
					"         <rps:ProcessingEnd>@@ProcessingEnd@@</rps:ProcessingEnd>\n" + 
					"         <rps:FunctionExecutionStatus>\n" + 
					"            <rps:Status>@@Status@@</rps:Status>\n" + 
					"         </rps:FunctionExecutionStatus>  \n" + 
					"         <rps:Iccid>@@Iccid@@</rps:Iccid> \n" + 
					"         <rps:EuiccResponseData>@@EuiccResponseData@@</rps:EuiccResponseData>\n" + 
					"      </rps:ES2-DownloadProfileResponse>\n" + 
					"   </soap:Body>\n" + 
					"</soap:Envelope>\n" + 
					"";
			
			
			   
			
				if(parameterMap.get("isresponsesuccessful").equalsIgnoreCase("true"))
				{
				parameterMap.put("response_success_template", responseSuccessTemplate);
				}
				
			
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("DownloadProfileCallback", parameterMap,
					request, response);
			logger.info("********************** DownloadProfileCallback API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	
	public ResponseEntity<?> EnableProfileCallback(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************EnableProfileCallback API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			String responseSuccessTemplate="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:add=\"http://www.w3.org/2005/08/addressing\" xmlns:ns=\"http://namespaces.gsma.org/esim-messaging/3\">\n" + 
					"   <soap:Header>\n" + 
					"      <RelatesTo RelationshipType=\"http://www.w3.org/2005/08/addressing/reply\">@@RelatesTo@@</RelatesTo>\n" + 
					"      <Action>@@Action@@</Action>\n" + 
					"      <MessageID>@@MessageID@@</MessageID>\n" + 
					"      <To>@@To@@</To>\n" + 
					"      <From>\n" + 
					"         <Address>@@Address@@</Address>\n" + 
					"      </From>\n" + 
					"   </soap:Header>\n" + 
					"  <soap:Body>\n" + 
					"      <rps:ES2-EnableProfileResponse>\n" + 
					"         <rps:ProcessingStart>@@ProcessingStart@@</rps:ProcessingStart> \n" + 
					"         <rps:ProcessingEnd>@@ProcessingEnd@@</rps:ProcessingEnd>\n" + 
					"         <rps:FunctionExecutionStatus>\n" + 
					"            <rps:Status>@@Status@@</rps:Status>\n" + 
					"         </rps:FunctionExecutionStatus>\n" + 
					"         <rps:Iccid>@@Iccid@@</rps:Iccid>\n" + 
					"         <rps:EuiccResponseData>@@EuiccResponseData@@</rps:EuiccResponseData>\n" + 
					"      </rps:ES2-EnableProfileResponse>\n" + 
					"   </soap:Body>\n" + 
					"</soap:Envelope>";
			
			
			   
			
				if(parameterMap.get("isresponsesuccessful").equalsIgnoreCase("true"))
				{
				parameterMap.put("response_success_template", responseSuccessTemplate);
				}
				
			
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("EnableProfileCallback", parameterMap,
					request, response);
			logger.info("********************** EnableProfileCallback API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	public ResponseEntity<?> DisableProfileCallback(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************DisableProfileCallback API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			String responseSuccessTemplate="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:add=\"http://www.w3.org/2005/08/addressing\" xmlns:ns=\"http://namespaces.gsma.org/esim-messaging/3\">\n" + 
					"   <soap:Header>\n" + 
					"      <RelatesTo RelationshipType=\"http://www.w3.org/2005/08/addressing/reply\">@@RelatesTo@@</RelatesTo>\n" + 
					"      <Action>@@Action@@</Action>\n" + 
					"      <MessageID>@@MessageID@@</MessageID>\n" + 
					"      <To>@@To@@</To>\n" + 
					"      <From>\n" + 
					"         <Address>@@Address@@</Address>\n" + 
					"      </From>\n" + 
					"   </soap:Header>\n" + 
					"  <soap:Body>\n" + 
					"      <rps:ES2-DisableProfileResponse>\n" + 
					"         <rps:ProcessingStart>@@ProcessingStart@@</rps:ProcessingStart> \n" + 
					"         <rps:ProcessingEnd>@@ProcessingEnd@@</rps:ProcessingEnd>\n" + 
					"         <rps:FunctionExecutionStatus>\n" + 
					"            <rps:Status>@@Status@@</rps:Status>\n" + 
					"         </rps:FunctionExecutionStatus>\n" + 
					"         <rps:Iccid>@@Iccid@@</rps:Iccid>\n" + 
					"         <rps:EuiccResponseData>@@EuiccResponseData@@</rps:EuiccResponseData>\n" + 
					"      </rps:ES2-DisableProfileResponse>\n" + 
					"   </soap:Body>\n" + 
					"</soap:Envelope>";
			
				if(parameterMap.get("isresponsesuccessful").equalsIgnoreCase("true"))
				{
				parameterMap.put("response_success_template", responseSuccessTemplate);
				}
				
			
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("DisableProfileCallback", parameterMap,
					request, response);
			logger.info("********************** DisableProfileCallback API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	public ResponseEntity<?> DeleteProfileCallback(Map<String, String> parameterMap, String countryCode, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		if (methodService == null ) {

			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			methodService = webApplicationContext.getBean(GenericMethodService.class);
		}
		
		if(genericProcess==null)
		{
			ServletContext servletContext = request.getSession().getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}
		
		try {
			logger.info("**********************************DeleteProfileCallback API called ***********************************");
             
			
			// adding countryCode and operator in parameter Map
			parameterMap.put(COUNTRY_CODE, countryCode);
			parameterMap.put(OPERATOR_NAME, operator);
			
			//	adding header parameters into Map
			Enumeration<?> header = request.getHeaderNames();
			while (header.hasMoreElements()) {
				String paramName = (String) header.nextElement(); 
				parameterMap.put(paramName, request.getHeader(paramName));
			}
			
			/**
			 * Adding Dummy Data for testing now.
			 * */
			System.out.println("Parameter Map is ===="+parameterMap);
			parameterMap.put("requestId", parameterMap.get(REQUEST_ID));
			
			String responseSuccessTemplate="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:add=\"http://www.w3.org/2005/08/addressing\" xmlns:ns=\"http://namespaces.gsma.org/esim-messaging/3\">\n" + 
					"   <soap:Header>\n" + 
					"      <RelatesTo RelationshipType=\"http://www.w3.org/2005/08/addressing/reply\">@@RelatesTo@@</RelatesTo>\n" + 
					"      <Action>@@Action@@</Action>\n" + 
					"      <MessageID>@@MessageID@@</MessageID>\n" + 
					"      <To>@@To@@</To>\n" + 
					"      <From>\n" + 
					"         <Address>@@Address@@</Address>\n" + 
					"      </From>\n" + 
					"   </soap:Header>\n" + 
					"  <soap:Body>\n" + 
					"      <rps:ES2-DeleteProfileResponse>\n" + 
					"         <rps:ProcessingStart>@@ProcessingStart@@</rps:ProcessingStart> \n" + 
					"         <rps:ProcessingEnd>@@ProcessingEnd@@</rps:ProcessingEnd>\n" + 
					"         <rps:FunctionExecutionStatus>\n" + 
					"            <rps:Status>@@Status@@</rps:Status>\n" + 
					"         </rps:FunctionExecutionStatus>\n" + 
					"         <rps:Iccid>@@Iccid@@</rps:Iccid>\n" + 
					"         <rps:EuiccResponseData>@@EuiccResponseData@@</rps:EuiccResponseData>\n" + 
					"      </rps:ES2-DeleteProfileResponse>\n" + 
					"   </soap:Body>\n" + 
					"</soap:Envelope>\n" + 
					"\n" + 
					"";
			
			   
			
				if(parameterMap.get("isresponsesuccessful").equalsIgnoreCase("true"))
				{
				parameterMap.put("response_success_template", responseSuccessTemplate);
				}
				
			
			
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("DeleteProfileCallback", parameterMap,
					request, response);
			logger.info("********************** DeleteProfileCallback API Execution Ended ******************************");
			return responseMessage;

		} catch (Exception exception) {
			logger.info(EXCEPTION_OCCURED + exception.getMessage());
			logger.error(exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
}
