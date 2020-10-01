/**
 * This Package contains controllers of GOUP APIs.
 */
package org.goup.controllers;

import java.util.Enumeration;
import java.util.LinkedHashMap;
/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.resources.JsonModification;
import org.goup.services.GoupEsimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import springfox.documentation.annotations.ApiIgnore;

/**
 * This class use as @Controller to call all GOUP Esim API's Defined In Operator Interfaces
 * 
 * @author	AmanAgarwal
 * @version	1.0
 * @since	2020-24-03
 * 
 */
@ApiIgnore
@Controller
public class GoupEsimController {
	
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GoupEsimService goupEsimService;

	/**
	 * This API is used to Download profile  on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to check user existance
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadProfileEsim", method = RequestMethod.POST)
	public ResponseEntity<?> downloadProfileEsim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupEsimService.downloadProfileEsim(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used to enable profile  on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to check user existance
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/enableProfileEsim", method = RequestMethod.POST)
	public ResponseEntity<?> enableProfileEsim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupEsimService.enableProfileEsim(parameterMap, request, response);

	}
	
	
	
	
	/**
	 * This API is used to delete profile  on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to check user existance
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteProfileEsim", method = RequestMethod.POST)
	public ResponseEntity<?> deleteProfileEsim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupEsimService.deleteProfileEsim(parameterMap, request, response);

	}
	
	
	
	
	
	/**
	 * This API is used to disable profile  on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to check user existance
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/disableProfileEsim", method = RequestMethod.POST)
	public ResponseEntity<?> disableProfileEsim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupEsimService.disableProfileEsim(parameterMap, request, response);

	}
	
	
	
	/**
	 * This API is used to set fall back attributes  on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to check user existance
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/setFallbackAttribute", method = RequestMethod.POST)
	public ResponseEntity<?> setFallbackAttribute(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupEsimService.setFallbackAttribute(parameterMap, request, response);

	}
	

	/**
	 * This API is used to update Subscription Address on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to updateSubscriptionAddress
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateSubscriptionAddress", method = RequestMethod.POST)
	public ResponseEntity<?> updateSubscriptionAddress(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupEsimService.updateSubscriptionAddress(parameterMap, request, response);

	}
	
	
	
}
