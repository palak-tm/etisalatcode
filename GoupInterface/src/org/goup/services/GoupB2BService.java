/**
 * This pacakage contains class related to GOUP APIs service implementation.
 */
package org.goup.services;

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

/**
 * This class use as Service to call all GOUP B2B APIs.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-03
 */
@Service
@SuppressWarnings("rawtypes")
public class GoupB2BService {
	
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OperatorInterfaceInfo operatorInterfaceInfo;	
	
	@Autowired
	private AuditServices logAudit;

	/**
	 * This API is used to get sim details on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sim details
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimDetails(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSimDetails", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to get sim usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sim usage info
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimUsage(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSimUsage", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to get sim session information on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sim session info
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> simSessionInfo(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "simSessionInfo", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to activate sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to activate sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> activateSim(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "activateSim", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to deactivate sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to deactivate sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> deactivateSim(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "deactivateSim", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to suspend sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to suspend sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> suspendSim(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "suspendSim", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to reactivate sim on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to reactivate sim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> reactivateSim(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "reactivateSim", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get sim session history on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sim session history
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimSessionHistory(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSimSessionHistory", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
		
	/**
	 * This API is used to echo resource on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to echo resource
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> echo(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "echo", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to update Rate Plan on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update Rate Plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateRatePlan(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "updateRatePlan", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to update communication plan on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update communication plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateCommunicationPlan(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "updateCommunicationPlan", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get sms details on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sms details
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSmsDetails(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSmsDetails", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to send sms on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to send sms
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> sendSms(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "sendSms", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}	
	
	/**
	 * This API is used to public profile mapping by ESIM.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to publish Profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> publishProfileMapping(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "publishProfileMapping", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to download profile on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to download profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> downloadProfile(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "downloadProfile", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to update virtual device settings on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update virtual device settings
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateVirtualDeviceSettings(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "updateVirtualDeviceSettings", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get sim List on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sim List
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimList(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSimList", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get sim audit history on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sim audit history
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSimAuditHistory(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSimAuditHistory", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get data usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get data usage
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getDataUsage(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getDataUsage", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get sms usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get sms usage
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSmsUsage(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSmsUsage", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to disconnect sessions on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to disconnect sessions
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> disconnectSessions(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "disconnectSessions", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get Invoice on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get invoice
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getInvoice(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getInvoice", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to update device settings on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update settings
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateDeviceSettings(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "updateDeviceSettings", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to switch profile.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to switch profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> switchProfile(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "switchProfile", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to replace hardware.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to replace hardware
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> replaceHardware(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "replaceHardware", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to update rating profile.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update rating profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> updateRatingProfile(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "updateRatingProfile", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * This API is used to get voice usage on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get voice usage
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getVoiceUsage(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getVoiceUsage", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * This API is used to get rate plans.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getRatePlans(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getRatePlans", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	

	/**
	 * This API is used to get rate plans.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getServicePlanList(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getServicePlanList", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	
	/**
	 * This API is used to get data plans on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getDataPlans(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getDataPlans", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	
	/**
	 * This API is used to get data plans on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get rate plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getServiceCoverageList(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator+"-"+country_code);
		
		if(className==null)
		{
			logAudit.auditLogInsert("Exception", "No Platform found for given Country Operator.", parameterMap.toString(), request);
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getServiceCoverageList", paramType, paramValue);
			
			if(object!=null)
			{
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
	public ResponseEntity<?> retrievePurchases(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "retrievePurchases", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	
	
	/**
	 * This API is used to attach service plan or change sim service profile.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to attach service plan
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> attachServicePlan(Map<String, String> parameterMap, HttpServletRequest request,
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
			Object object = Constant.executeMethods(className, "attachServicePlan", paramType, paramValue);

			if (object != null) {
				return (ResponseEntity<?>) object;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	
	/**
	 * This API is used to attach service plan or change sim service profile.
	 * 
	 * @param parameterMap
	 *            api parameters as Map
	 * @param request
	 *            incoming request to attach service plan
	 * @param response
	 *            response of api
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> GetExpiredUserPurchasesBatchAPI(Map<String, String> parameterMap, HttpServletRequest request,
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

	
	
}
