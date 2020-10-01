package org.goup.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.services.GoupB2BService;
import org.goup.services.GoupSoapServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springfox.documentation.annotations.ApiIgnore;



/**
 * This class use as @Controller to call all GOUP SOAP API's Defined In Operator Interfaces
 * 
 * @author	Aman Agarwal
 * @version	1.0
 * @since	2019-11-01
 */


@ApiIgnore
@Controller
public class GoupSoapController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GoupSoapServices goupSoapService;
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/OEMOrderRequest", method = RequestMethod.GET)
	public ResponseEntity<?> OEMOrderRequest(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.OEMOrderRequest(parameterMap, request, response);

	}
	
	
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/ES2_HandleProfileDeletedNotification", method = RequestMethod.GET)
	public ResponseEntity<?> ES2_HandleProfileDeletedNotification(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.ES2_HandleProfileDeletedNotification(parameterMap, request, response);

	}
	

	
	
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/ES2_HandleProfileDisabledNotification", method = RequestMethod.GET)
	public ResponseEntity<?> ES2_HandleProfileDisabledNotification(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.ES2_HandleProfileDisabledNotification(parameterMap, request, response);

	}
	
	

	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/ES2_HandleProfileEnabledNotification", method = RequestMethod.GET)
	public ResponseEntity<?> ES2_HandleProfileEnabledNotification(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.ES2_HandleProfileEnabledNotification(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/DownloadProfileCallback", method = RequestMethod.GET)
	public ResponseEntity<?> DownloadProfileCallback(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.DownloadProfileCallback(parameterMap, request, response);

	}
	
	
	
	
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/notifyOEM", method = RequestMethod.GET)
	public ResponseEntity<?> notifyOEM(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.notifyOEM(parameterMap, request, response);

	}
	

	
	
	
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/EnableProfileCallback", method = RequestMethod.GET)
	public ResponseEntity<?> EnableProfileCallback(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.EnableProfileCallback(parameterMap, request, response);

	}

	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/DisableProfileCallback", method = RequestMethod.GET)
	public ResponseEntity<?> DisableProfileCallback(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.DisableProfileCallback(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used to Attach Service plan or changes sim service profile
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to Attach service plan or change sim service profile
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/DeleteProfileCallback", method = RequestMethod.GET)
	public ResponseEntity<?> DeleteProfileCallback(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupSoapService.DeleteProfileCallback(parameterMap, request, response);

	}
	
	
	
}
