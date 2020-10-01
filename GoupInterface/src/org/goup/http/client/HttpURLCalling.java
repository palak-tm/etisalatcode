/**
 * This package contains classes as Component, which is used to call the apis
 * of EndNode Applications like BSS,ESim,GlobeConnect and more.
 */
package org.goup.http.client;

/**
 * To Import Classes to access their functionality
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.log4j.Logger;
import org.goup.mno.interface_implementation.GConnectInterface;
import org.springframework.stereotype.Component;

/**
 * This class use as Component to call all API's of End Nodes and return their responses
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-08-01
 */
@Component
public class HttpURLCalling {
	
	/**
	 * instantiate logger
	 */
	Logger logger = Logger.getLogger(HttpURLCalling.class);

	/**
	 * This Method is used to Call the API's of End Node Server with Their Request Method Type
	 * 
	 * @param url
	 * 			url to call
	 * @param passingParameter
	 * 			request parameters
	 * @param headerMap
	 * 			header parameters in Map
	 * @return
	 */
	public String getData(String url, String passingParameter, Map<String, String> headerMap) {

		try {
			URL urlToCall = new URL(url);

			HttpURLConnection httpConectionWithUrl = (HttpURLConnection) urlToCall.openConnection();

			// add reuqest header
			httpConectionWithUrl.setRequestMethod("POST");
			httpConectionWithUrl.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			if (headerMap != null) {
				for (Map.Entry<String,String> parameterEntry : headerMap.entrySet()) {
					logger.info(parameterEntry.getKey() + "->" + parameterEntry.getValue());
					httpConectionWithUrl.setRequestProperty(parameterEntry.getKey(), parameterEntry.getValue());
				}

			}

			 //  To add headers to call other API's
			String urlParameters = passingParameter;
			
			// Send post request
			httpConectionWithUrl.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			//  To Get Response Code from called API
			int responseCode = httpConectionWithUrl.getResponseCode();
			logger.info("Sending 'POST' request to URL : " + url);
			logger.info("Post parameters : " + urlParameters);
			logger.info("Response Code : " + responseCode);
			
			//  If dosen't get success code than return null
			if (responseCode != 200) {
				return null;
			}
			
			//  To get the response from the API which was called
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConectionWithUrl.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// To Return the Response
			return response.toString();

		} catch (Exception exception) {
			//  To Catch the exception if it was unable to process the request
			exception.printStackTrace();
			return exception.getMessage();
		}
	}
	

}
