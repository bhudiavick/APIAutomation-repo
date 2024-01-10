package basic.rest.postcall;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
public class createGitHubRepo {
	@Test
	public void createGitRepo(){
		RestAssured.baseURI = "https://api.github.com";
		String bearerToken= "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";
		
		System.out.println("Starting code");
		given().
			header("Content-Type","application/json").
			header("Authorization","Bearer " + bearerToken).
			body("{\"name\":\"APIAutomation-repo2\","
					+ "\"description\":\"Automation using Rest Assured!\""
					+ "}").
		when().
			post("/user/repos").
		then().
			assertThat().statusCode(201).and().
			contentType(ContentType.JSON).and().
			body("name",equalTo("APIAutomation-repo2")).and().
			body("description",equalTo("Automation using Rest Assured!"));
			
		
		System.out.println("Posted data successfullyy");
		System.out.println();
	}
}
