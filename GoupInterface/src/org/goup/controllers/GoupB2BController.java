/**
 * This Package contains controllers of GOUP APIs.
 */
package org.goup.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.resources.JsonModification;
import org.goup.services.GoupB2BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * This class use as @Controller to call all GOUP B2B API's Defined In Operator Interfaces
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-01
 */
@ApiIgnore
@Controller
public class GoupB2BController {
	
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GoupB2BService goupB2BService;

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
	@RequestMapping(value = "/getSimDetails", method = RequestMethod.GET)
	public ResponseEntity<?> getSimDetails(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSimDetails(parameterMap, request, response);

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
	@RequestMapping(value = "/getSimUsage", method = RequestMethod.GET)
	public ResponseEntity<?> getSimUsage(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSimUsage(parameterMap,request, response);

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
	@RequestMapping(value = "/simSessionInfo", method = RequestMethod.GET)
	public ResponseEntity<?> simSessionInfo(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.simSessionInfo(parameterMap, request, response);

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
	@RequestMapping(value = "/activateSim", method = RequestMethod.POST)
	public ResponseEntity<?> activateSim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(bodyParam!=null)
		{
			JsonModification.parse(bodyParam, parameterMap);
		}
	
		return goupB2BService.activateSim(parameterMap, request, response);

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
	@RequestMapping(value = "/deactivateSim", method = RequestMethod.POST)
	public ResponseEntity<?> deactivateSim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(bodyParam!=null)
		{
			JsonModification.parse(bodyParam, parameterMap);
		}
		return goupB2BService.deactivateSim(parameterMap, request, response);

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
	@RequestMapping(value = "/suspendSim", method = RequestMethod.POST)
	public ResponseEntity<?> suspendSim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(bodyParam!=null)
		{
			JsonModification.parse(bodyParam, parameterMap);
		}
		return goupB2BService.suspendSim(parameterMap, request, response);

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
	@RequestMapping(value = "/reactivateSim", method = RequestMethod.POST)
	public ResponseEntity<?> reactivateSim(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(bodyParam!=null)
		{
			JsonModification.parse(bodyParam, parameterMap);
		}
		return goupB2BService.reactivateSim(parameterMap, request, response);

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
	@RequestMapping(value = "/getSimSessionHistory", method = RequestMethod.GET)
	public ResponseEntity<?> getSimSessionHistory(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSimSessionHistory(parameterMap, request, response);

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
	@RequestMapping(value = "/echo", method = RequestMethod.GET)
	public ResponseEntity<?> echo(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.echo(parameterMap, request, response);

	}
	
	/**
	 * This API is used to update Rate Plan on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update Rate plan
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateRatePlan", method = RequestMethod.POST)
	public ResponseEntity<?> updateRatePlan(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.updateRatePlan(parameterMap, request, response);

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
	@RequestMapping(value = "/updateCommunicationPlan", method = RequestMethod.POST)
	public ResponseEntity<?> updateCommunicationPlan(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.updateCommunicationPlan(parameterMap, request, response);

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
	@RequestMapping(value = "/getSmsDetails", method = RequestMethod.GET)
	public ResponseEntity<?> getSmsDetails(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSmsDetails(parameterMap, request, response);

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
	@RequestMapping(value = "/sendSms", method = RequestMethod.POST)
	public ResponseEntity<?> sendSms(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.sendSms(parameterMap, request, response);

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
	@RequestMapping(value = "/publishProfileMapping", method = RequestMethod.POST)
	public ResponseEntity<?> publishProfileMapping(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.publishProfileMapping(parameterMap, request, response);

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
	@RequestMapping(value = "/downloadProfile", method = RequestMethod.POST)
	public ResponseEntity<?> downloadProfile(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.downloadProfile(parameterMap, request, response);

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
	@RequestMapping(value = "/updateVirtualDeviceSettings", method = RequestMethod.POST)
	public ResponseEntity<?> updateVirtualDeviceSettings(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.updateVirtualDeviceSettings(parameterMap, request, response);

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
	@RequestMapping(value = "/getSimList", method = RequestMethod.GET)
	public ResponseEntity<?> getSimList(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSimList(parameterMap, request, response);

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
	@RequestMapping(value = "/getSimAuditHistory", method = RequestMethod.GET)
	public ResponseEntity<?> getSimAuditHistory(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSimAuditHistory(parameterMap, request, response);

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
	@RequestMapping(value = "/getDataUsage", method = RequestMethod.GET)
	public ResponseEntity<?> getDataUsage(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getDataUsage(parameterMap, request, response);

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
	@RequestMapping(value = "/getSmsUsage", method = RequestMethod.GET)
	public ResponseEntity<?> getSmsUsage(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getSmsUsage(parameterMap, request, response);

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
	@RequestMapping(value = "/disconnectSessions", method = RequestMethod.POST)
	public ResponseEntity<?> disconnectSessions(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.disconnectSessions(parameterMap, request, response);

	}
	
	/**
	 * This API is used to get invoice on the basis of given iccid/imsi.
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
	@RequestMapping(value = "/getInvoice", method = RequestMethod.GET)
	public ResponseEntity<?> getInvoice(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getInvoice(parameterMap, request, response);

	}
	
	/**
	 * This API is used to update device settings on the basis of given parameter.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to update devicesettings
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateDeviceSettings", method = RequestMethod.POST)
	public ResponseEntity<?> updateDeviceSettings(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.updateDeviceSettings(parameterMap, request, response);

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
	@RequestMapping(value = "/switchProfile", method = RequestMethod.POST)
	public ResponseEntity<?> switchProfile(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false)  String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.switchProfile(parameterMap, request, response);

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
	@RequestMapping(value = "/replaceHardware", method = RequestMethod.POST)
	public ResponseEntity<?> replaceHardware(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.replaceHardware(parameterMap, request, response);

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
	@RequestMapping(value = "/updateRatingProfile", method = RequestMethod.POST)
	public ResponseEntity<?> updateRatingProfile(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {
		
		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.updateRatingProfile(parameterMap, request, response);

	}
	
	/**
	 * This API is used to get voice usage details on the basis of given iccid/imsi.
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
	@RequestMapping(value = "/getVoiceUsage", method = RequestMethod.GET)
	public ResponseEntity<?> getVoiceUsage(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getVoiceUsage(parameterMap, request, response);

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
	@RequestMapping(value = "/getRatePlans", method = RequestMethod.GET)
	public ResponseEntity<?> getRatePlans(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getRatePlans(parameterMap, request, response);

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
	@RequestMapping(value = "/getServicePlanList", method = RequestMethod.GET)
	public ResponseEntity<?> getServicePlanList(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getServicePlanList(parameterMap, request, response);

	}
	
	/**
	 * This API is used to get data plans.
	 * 
	 * @param parameterMap
	 * 			api parameters as Map
	 * @param request
	 * 			incoming request to get data plans
	 * @param response
	 * 			response of api
	 * @return	Return the response message
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataPlans", method = RequestMethod.GET)
	public ResponseEntity<?> getDataPlans(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getDataPlans(parameterMap, request, response);

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
	@RequestMapping(value = "/getServiceCoverageList", method = RequestMethod.POST)
	public ResponseEntity<?> getServiceCoverageList(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.getServiceCoverageList(parameterMap, request, response);

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
	@RequestMapping(value = "/retrievePurchases", method = RequestMethod.GET)
	public ResponseEntity<?> retrievePurchases(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.retrievePurchases(parameterMap, request, response);

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
	@RequestMapping(value = "/GetExpiredUserPurchasesBatchAPI", method = RequestMethod.GET)
	public ResponseEntity<?> GetExpiredUserPurchasesBatchAPI(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		return goupB2BService.GetExpiredUserPurchasesBatchAPI(parameterMap, request, response);

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
	@RequestMapping(value = "/attachServicePlan", method = RequestMethod.POST)
	public ResponseEntity<?> attachServicePlan(@RequestParam Map<String, String> parameterMap, @RequestBody (required = false) String bodyParam,
			HttpServletRequest request, HttpServletResponse response) {

		JsonModification.parse(bodyParam, parameterMap);
		return goupB2BService.attachServicePlan(parameterMap, request, response);

	}
	
	
	
	
	
	
	
	
}
