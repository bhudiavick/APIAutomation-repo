package basic.rest.postcall;
import  io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static  io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class deleteManualRepo {
	public String baseUrl = "https://api.github.com";
	public String bearerToken= "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";
	public String repoName;
	
	@Test
	public void manualDeleteRepository() {
		
		
		String user = "bhudiavick/";
		String repoNameManual = "APIAutomation-repo3";
		RestAssured.baseURI = baseUrl;
		RequestSpecification requestSpec = given().
				header("Content-Type","application/json").
				header("Authorization","Bearer " + bearerToken);
		requestSpec.given().
		when().
		get("/repos/" + user +  repoNameManual).
		then().
		assertThat().statusCode(200);
		
		requestSpec.given().
		when().
		delete("/repos/" + user +  repoNameManual).
		then().
		assertThat().statusCode(204);
		
		requestSpec.given().
		when().
		get("/repos/" + user +  repoNameManual).
		then().
		assertThat().statusCode(404);
		
		
	}
}
