package resource.commonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {

	RequestSpecification requestSpecification;
	String bearer_token = "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";
	Response response;
	String baseURI = "https://api.github.com";
	RestLogger restLogger = new RestLogger();

	public Response postRequest(String resourcePath, String payload) {
		RestLogger.info("BaseURI is - " + baseURI + resourcePath);
		RestLogger.info("Payload to be sent is " + payload);
		requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		response = requestSpecification.post(baseURI + resourcePath);
		RestLogger.info("Response of request is " + response.getBody().asString());
		return response;
	}

	public Response deleteRequest(String resourcePath, String repo_name) {
		String requestURI = baseURI + resourcePath + repo_name;
		RestLogger.info("Delete URI is - " + requestURI);
		requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		response = requestSpecification.delete(requestURI);
		return response;
	}
}
