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
import org.goup.services.GoupB2CService;
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
 * This class use as @Controller to call all GOUP B2C API's Defined In Operator Interfaces
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-01
 * 
 */
@ApiIgnore
@Controller
public class GoupB2CController {
	
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GoupB2CService goupB2CService;

	/**
	 * This API is used to check user is exists or not on the basis of given iccid/imsi.
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
	@RequestMapping(value = "/userExistenceCheck", method = RequestMethod.POST)
	public ResponseEntity<?> userExistenceCheck(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.userExistenceCheck(parameterMap, request, response);

	}
	
	/**
	 * This API is used to register user
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to user registration
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 */
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST,produces ="application/json;charset=UTF-8",consumes ="application/json;charset=UTF-8")
	public ResponseEntity<?> userRegistration(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			
			HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Body Parameters At Interface::"+bodyParam);
		JsonModification.parse(bodyParam, parameterMap);
		
		System.out.println("Body Parameters in Parameter Map::"+parameterMap);
		return goupB2CService.userRegistration(parameterMap, request, response);

	}
	
	/**
	 * This API is used to remove user on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to remove user
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/userRemoval", method = RequestMethod.POST)
	public ResponseEntity<?> userRemoval(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.userRemoval(parameterMap, request, response);

	}
	
	/**
	 * This API is used to update user on the basis of given iccid/imsi.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to update user
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.updateUser(parameterMap, request, response);

	}
	
	/**
	 * This API is used to swap sim of an user.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to sim swap
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/userSimSwap", method = RequestMethod.POST)
	public ResponseEntity<?> userSimSwap(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.userSimSwap(parameterMap, request, response);

	}
	
	/**
	 * This API is used to user retrieval.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to user retrieval
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/userRetrieval", method = RequestMethod.POST)
	public ResponseEntity<?> userRetrieval(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.userRetrieval(parameterMap, request, response);

	}
	
	/**
	 * This API is used to add order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to add order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<?> addOrder(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.addOrder(parameterMap, request, response);

	}
	
	/**
	 * This API is used to check order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to check order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkOrder", method = RequestMethod.POST)
	public ResponseEntity<?> checkOrder(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.checkOrder(parameterMap, request, response);

	}
	
	/**
	 * This API is used to cancel order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to cancel order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public ResponseEntity<?> cancelOrder(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.cancelOrder(parameterMap, request, response);

	}
	
	/**
	 * This API is used to retrieve order.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to retrieve order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/retrieveOrder", method = RequestMethod.POST)
	public ResponseEntity<?> retrieveOrder(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.retrieveOrder(parameterMap, request, response);

	}
	
	/**
	 * This API is used to get available offer.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAvailableOffer", method = RequestMethod.POST)
	public ResponseEntity<?> getAvailableOffer(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.getAvailableOffer(parameterMap, request, response);

	}

	
	/**
	 * This API is used to get available offer.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateUserAmx", method = RequestMethod.POST)
	public ResponseEntity<?> updateUserAmx(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.updateUserAmx(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used to get available offer.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/buyProductAmx", method = RequestMethod.POST)
	public ResponseEntity<?> buyProductAmx(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.buyProductAmx(parameterMap, request, response);

	}

	
	/**
	 * This API is used to get available offer.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/addOrderPgo", method = RequestMethod.POST)
	public ResponseEntity<?> addOrderPgo(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.addOrderPgo(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used for sim provisioning.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/simProvisioning", method = RequestMethod.POST)
	public ResponseEntity<?> simProvisioning(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.simProvisioning(parameterMap, request, response);

	}
	


	/**
	 * This API is used for sim provisioning.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePlan", method = RequestMethod.POST)
	public ResponseEntity<?> changePlan(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.changePlan(parameterMap, request, response);

	}
	

	/**
	 * This API is used for sim provisioning.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to get available offer
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/simUnprovisioning", method = RequestMethod.POST)
	public ResponseEntity<?> simUnprovisioning(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.simUnprovisioning(parameterMap, request, response);

	}
	

	
	
	
	
	
	

	/**
	 * This API is used for query about plan.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to queryPlanList
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPlanList", method = RequestMethod.POST)
	public ResponseEntity<?> queryPlanList(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.queryPlanList(parameterMap, request, response);

	}
	
	
	
	/**
	 * This API is used to change Sim.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to changeSim
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeSim", method = RequestMethod.POST)
	public ResponseEntity<?> changeSim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.changeSim(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used to reverse Order
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to reverse order
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/reverseOrder", method = RequestMethod.POST)
	public ResponseEntity<?> reverseOrder(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.reverseOrder(parameterMap, request, response);

	}
	
	
	/**
	 * This API is used to reserve authorize fund
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to authorize fund
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/reserveOrder", method = RequestMethod.POST)
	public ResponseEntity<?> reserveOrder(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.reserveOrder(parameterMap, request, response);

	}
	
	
	
	
	/**
	 * This API is used to capture fund
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param bodyParam
	 * 			request body data parameters
	 * @param request
	 * 			incoming request to capture fund
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/captureFund", method = RequestMethod.POST)
	public ResponseEntity<?> captureFund(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2CService.captureFund(parameterMap, request, response);

	}
}
