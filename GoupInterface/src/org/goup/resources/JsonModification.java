/**
 * org.goup.resources this package contatining Java Class 
 * JsonModification which is used to convert json String 
 * to HashMap[String,String] . It is generic class which extract 
 * any json array or json object and fetch all parameter and its value
 * and put it in hashmap.
 */
package org.goup.resources;

/**
 * To Import Classes to access their functionality
 */
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * JsonModification class is used to convert json String to
 * HashMap[String,String] . It is generic class which extract any json array or
 * json object and fetch all parameter and its value and put it in hashmap.
 * 1)parse(String json,HashMap<String, String> map) : it is recursive method
 * which executed till all json object convert to hashmap. 2)
 * parseJsonArray(String jsonArray,HashMap<String, String> map) : This Method is
 * use to convert json object to mao of parameter and value
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-07-31
 */
public class JsonModification {

	/**
	 * it is recursive method which executed till all json object convert to
	 * hashmap.
	 * 
	 * @param json:Json
	 *            String containing Json Object and Json Array
	 * @param map:It
	 *            hold all parameter and value which is extract from json variable
	 * @return:HashMap<String, String> map which havin all parameter and value
	 */
	public static Map<String, String> parse(final String json, final Map<String, String> map) {
		try {

			// Instance of JsonFactory for Object Mapper istance
			final JsonFactory factory = new JsonFactory();

			final ObjectMapper mapper = new ObjectMapper(factory);

			// create JsonNode from json String
			final JsonNode rootNode = mapper.readTree(json);

			// iterate till it fetch all parameter and value from json string
			final Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
			while (fieldsIterator.hasNext()) {

				final Map.Entry<String, JsonNode> field = fieldsIterator.next();

				// if normal json it put value to map
				map.put(field.getKey(), String.valueOf(field.getValue()));

				// if json oject again recurse parse method
				if ((String.valueOf(field.getValue()).startsWith("{")
						&& String.valueOf(field.getValue()).endsWith("}"))) {

					parse(String.valueOf(field.getValue()), map);

				} else

				// if json array it invoke parseJsonArray
				if (String.valueOf(field.getValue()).startsWith("[{")
						&& String.valueOf(field.getValue()).endsWith("}]")) {
					map.put(field.getKey(), String.valueOf(field.getValue()));
					parseJsonArray(String.valueOf(field.getValue()), map);

				} else {
					map.put(field.getKey(), String.valueOf(field.getValue()).replaceAll("\"", ""));
				}

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	/**
	 * parseJsonArray(String jsonArray,HashMap<String, String> map) :This Method is
	 * use to convert json object to map of parameter and value
	 * 
	 * @param jsonArray:String
	 *            of json Array
	 * @param map:HashMap<String,
	 *            String> map havin all parameter and value extract form json
	 */
	public static void parseJsonArray(String jsonArray, Map<String, String> map) {
		try {
			JSONArray jsonArray1 = new JSONArray(jsonArray);
			for (int i = 0; i < jsonArray1.length(); i++) {
				JSONObject json = jsonArray1.getJSONObject(i);
				Iterator<String> keys = json.keys();

				while (keys.hasNext()) {
					String key = keys.next();
					map.put(key, String.valueOf(json.get(key)));
					
				}

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}