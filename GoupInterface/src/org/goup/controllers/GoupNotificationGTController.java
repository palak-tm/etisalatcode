/**
 * This package contains controllers of GOUP Apis.
 */
package org.goup.controllers;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.services.GoupNotificationGTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.annotations.ApiIgnore;

/**
 * This class use as @Controller to call all GOUP B2B Notification API's Defined In Operator Interfaces
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-31
 * 
 */
@ApiIgnore
@Controller
public class GoupNotificationGTController {
	
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GoupNotificationGTService goupNotificationGTService;	
	
	/**
	 * This api is used to send notification for sim activation. MNO will call this api.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			request object
	 * @param response
	 * 			response object
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/activateSimNotification", method=RequestMethod.POST)
	public ResponseEntity<?> activateSimNotification(@RequestBody String param,
			HttpServletRequest request, HttpServletResponse response) {

		return goupNotificationGTService.activateSimNotification(param, request, response);

	}
	
	/**
	 * This api is used to send notification for sim deactivation. MNO will call this api.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			request object
	 * @param response
	 * 			response object
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/deactivateSimNotification", method=RequestMethod.POST)
	public ResponseEntity<?> deactivateSimNotification(@RequestBody String param,
			HttpServletRequest request, HttpServletResponse response) {

		return goupNotificationGTService.deactivateSimNotification(param, request, response);

	}
	
	/**
	 * This api is used to send notification for sim suspend activity. MNO will call this api.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			request object
	 * @param response
	 * 			response object
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/suspendSimNotification/notifications/SIMSuspended", method=RequestMethod.POST)
	public ResponseEntity<?> suspendSimNotification(@RequestBody String param,
			HttpServletRequest request, HttpServletResponse response) {

		return goupNotificationGTService.suspendSimNotification(param, request, response);

	}
	
	/**
	 * This api is used to send notification for sim reactivation. MNO will call this api.
	 * 
	 * @param param
	 * 			request body parameters
	 * @param request
	 * 			request object
	 * @param response
	 * 			response object
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/reactivateSimNotification", method=RequestMethod.POST)
	public ResponseEntity<?> reactivateSimNotification(@RequestBody String param,
			HttpServletRequest request, HttpServletResponse response) {

		return goupNotificationGTService.reactivateSimNotification(param, request, response);

	}	
	

}
