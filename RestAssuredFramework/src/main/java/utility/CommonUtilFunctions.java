package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {

	public static JsonPath jsonPath;
	
	public static String getResponseKeyValue(String response_body,String response_key) {
		jsonPath = new JsonPath(response_body);
		String key_value = jsonPath.get(response_key);
		return key_value;
		
	}
	public static int getStatusCode(Response response) {
		RestFWLogger.initLogger();
		int status_code = response.getStatusCode();
		RestFWLogger.info("Response status code is - " + status_code);
		return status_code;
	}
	
	public static String getStatusMessage(Response response) {
		RestFWLogger.initLogger();
		String status_message = response.getStatusLine();
		RestFWLogger.info("Response status message is - " + status_message);
		return status_message;
	}
	
	public static String getResponseHeader(Response response, String header_key) {
		RestFWLogger.initLogger();
		String response_header = response.getHeader(header_key);
		RestFWLogger.info("Response header settings for " + header_key + " is - " + response_header);
		return response_header;
	}
	
	public static String getResponseContentType(Response response) {
		RestFWLogger.initLogger();
		String content_type = response.getContentType();
		RestFWLogger.info("Response content type is -  " + content_type);
		return content_type;
	}
	
	public static int getResponseExecutionTime(Response response) {
		RestFWLogger.initLogger();
		int response_executionTime = (int)response.getTime();
		RestFWLogger.info("Response execution time is - " + response_executionTime);
		return response_executionTime;
	}
	
}
