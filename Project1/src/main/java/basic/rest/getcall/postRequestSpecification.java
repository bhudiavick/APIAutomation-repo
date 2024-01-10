package basic.rest.getcall;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static  io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class postRequestSpecification {
	@Test
	public void createRequestUsingRequestSpec() {
		
		RestAssured.baseURI = "https://api.github.com";
		String bearerToken= "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";
		String responseBody = "{\"name\":\"APIAutomation-repo1\","
				+ "\"description\":\"Automation using Rest Assured!\""
				+ "}";
		
		RequestSpecification requestSpec = given().
				header("Content-Type","application/json").
				header("Authorization","Bearer " + bearerToken).
				body(responseBody);
		
		requestSpec.log().all();
		
		Response response = requestSpec.
		when().
		post("/user/repos").
		then().
		assertThat().statusCode(201).and().
		contentType(ContentType.JSON).
		extract().response();
		
		
		JsonPath responseAsJson = new JsonPath(response.asString());
		System.out.println("name : " + responseAsJson.get("name"));
		System.out.println("node_id : " + responseAsJson.get("node_id"));
		System.out.println("full_name : " + responseAsJson.get("full_name"));
		
		
		
	}
	
}
