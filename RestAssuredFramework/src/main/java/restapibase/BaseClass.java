package restapibase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtilFunctions;
import utility.RestFWLogger;

public class BaseClass {
	
	//baseClass simply sets a template for the various request methods CRUD actions
	//it takes in the requestURI which is a endpoint that the CRUD action will be targetted against
	//the is a requestspecification which is part of the restassured library
	// its does what the name suggest, which is build the speciification of the request which is to be sent
	//this includes any contentType, header,body,bearer tokens
	//it will finally conclude by returning the Response object to the calling class to do further assertions
	//the calling class will also be used to build out the requestURI by a utility class called createURL
	//the createURL class will hold the constant value for the base url, and also allow calling class to append a actual target api end point
	//there is a Authn class within the utility for the constant bearertoken, which is fetched by the calling class
	//with the help of a payloadGenerator, the calling class can call the generator to fetch data in a String format from a file
	//this payloadGenerator will fetch from resource package which contains 1 or many json files to be processed
	public static Response getRequest(String requestURI) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayload) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is - " + requestURI);
		RestFWLogger.info("Request payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}
	public static Response postRequest(String requestURI, String requestPayload, String bearer_token) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is - " + requestURI);
		RestFWLogger.info("Request payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		//requestSpecification.log().all();
		requestSpecification.header("Authorization","Bearer " + bearer_token);
		//requestSpecification.log().all();
		Response response = requestSpecification.post(requestURI);
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}
	public static Response putRequest(String requestURI, String requestPayload) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is - " + requestURI);
		RestFWLogger.info("Request payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}
	
	public static Response deleteRequest(String requestURI, String bearer_token) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer " + bearer_token);
		Response response = requestSpecification.delete(requestURI);
		RestFWLogger.info("Response status code is - " + response.getStatusCode());
		RestFWLogger.info("Response status code is from common functions - " + CommonUtilFunctions.getStatusCode(response));
		return response;
	}
	
	public static Response deleteRequest(String requestURI, String requestPayload,String bearer_token ) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is - " + requestURI);
		RestFWLogger.info("Request Payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer " + bearer_token);
		Response response = requestSpecification.delete(requestURI);
		RestFWLogger.info("Response status code is - " + response.getStatusCode());
		RestFWLogger.info("Response status code is from common functions - " + CommonUtilFunctions.getStatusCode(response));		
		return response;
	}

}