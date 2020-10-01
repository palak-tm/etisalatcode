/**
 * This Package contains Service classes for GOUP APIs.
 */
package org.goup.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.goup.constant.ProcessParameter;
import org.goup.generic_service.GenericService;
import org.goup.request.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class work as a Service class for Generic Process for API Calling to
 * call Procedure and retrieve their data by getting parameter in map and
 * requestType as key to get the procedure which is to be called.
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-03
 */
@Service
public class GenericProcess {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;
	
	/**
	 * instantiate logger object
	 */
	Logger logger = Logger.getLogger(GenericProcess.class);

	/**
	 * This method is used to call stored procedure.
	 * @param requestType:-
	 *            Key to get Procedure Name
	 * @param map
	 *           input Parameters to call procedure
	 * @param clz
	 *            to set the response
	 * @param request
	 *            to get UserKey and userId From https request along with token
	 * @param response
	 * 				{@link HttpServletResponse}
	 * @return Message Response
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public Message GenericProcedureCalling(String requestType, Map<String, String> map, Class clz,
			HttpServletRequest request, HttpServletResponse response) {
		
		//  To Inizialize the response Message
		Message responseMessage = new Message();

		try {

			//  to store stored Procedure Parameter in array of object
			Object[] storedProcedureParameter = null;
			
			//  To get Map of Stored Procedure
			Map<String, Object> procedureRequestMap = processParameter.getMaps();

			//  To get Parameter List in List Of Object
			List<Object> parameterList = new ArrayList<>();
			
			//  Initializing sql query and its param to call procedure
			String sql = null;
			String params = null;

			
			/* This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
			 */
			if (procedureRequestMap.get(requestType) != null) {
				String value = procedureRequestMap.get(requestType).toString();

				params = value.substring(value.indexOf('(') + 1, value.indexOf(')'));

				String sqlValue = value.substring(0, value.indexOf('('));
				String key = value.substring(value.indexOf('('));

				StringBuilder builder = new StringBuilder(
						key.replaceAll("[^,()]", "").replace(")", ",)").replace(",", "?,"));
				
				//  Check the value of params if empty or not
				if (params.isEmpty()) {
					sql = sqlValue + "()";
				} else {
					sql = sqlValue + "" + builder.deleteCharAt(builder.lastIndexOf(",")).toString();
				}

			}

			/* Firstly split the parameters with comma,and then trim user_key
			 * and userId and manipulate according to our requirements and store
			 * it in a map.
			 */
			for (String checkString : params.split(",")) {

				if (map == null) {
					continue;
				}

				if (checkString.trim().equals("user_key")) {

					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					continue;
				}

				if (checkString.trim().equals("user_id")) {
					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					continue;
				}
				if (!params.isEmpty()) {
					if (map.get(checkString.trim()) != null) {
						String value = map.get(checkString.trim());

						if (value.isEmpty()) {
							parameterList.add(null);
						} else {
							parameterList.add(value);
						}
					} else {
						parameterList.add(null);
					}
				}
			}
			
			//  To Print Parameters and stored Procedure which will be called
			logger.info("parameter parameterList:- " + parameterList + ", requestedApi data:- " + sql);

			//  All the parameters are added in a list of objects.
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			if (sql != null) {

				Object object = null;
				
				/* The condition check if parameters received from procedure are
				 * null or not and call it according to the coming input
				 */
				if (storedProcedureParameter == null) {
					if (clz != null) {
						object = genericService.executeThirdPartyProcesure(clz, sql);
					} else {
						object = genericService.executeThirdPartyProcesure(null, sql);
					}

				} else {
					if (clz != null) {
						object = genericService.executeThirdPartyProcesure(clz, sql, storedProcedureParameter);
					} else {

						object = genericService.executeThirdPartyProcesure(null, sql, storedProcedureParameter);
						logger.info("Response From Database :- " + object);
					}

				}
				 
				//  return success message
				if (object != null) {

					responseMessage.setDescription("Process Success");
					responseMessage.setObject(object);
					responseMessage.setValid(true);

					return responseMessage;
				}

			}

		} catch (Exception exception) {			
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", exception);
			exception.printStackTrace();

			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			
			//  return error message
			return responseMessage;

		}

		//  Return Error Message when issue with parameter or program issue
		logger.setLevel(org.apache.log4j.Level.ERROR);
		logger.setPriority(Priority.ERROR);
		logger.error("Process Fail");
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);

		return responseMessage;
	}
	
	
	


}
