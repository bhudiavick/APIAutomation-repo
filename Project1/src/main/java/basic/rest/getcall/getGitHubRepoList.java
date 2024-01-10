package basic.rest.getcall;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import scala.collection.generic.BitOperations.Int;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class getGitHubRepoList {
	
	public String baseUrl = "https://api.github.com";
	public String bearerToken= "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";
	//public String repoName;
	
	
	@Test
	public void getGitHubRepo(){
		RestAssured.baseURI = baseUrl;
		RequestSpecification requestSpec = given().
				header("Content-Type","application/json").
				header("Authorization","Bearer " + bearerToken);
		
		Response response = requestSpec.given().
		when().
			get("/user/repos").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("owner.login",hasItems("bhudiavick")).
			extract().response();
			
		String responseData = response.asString();
		JsonPath responseJson = new JsonPath(responseData);
		print(responseData);
		System.out.println("count of name data: " + responseJson.getInt("name.size()"));
		
	}
	
	public void print(String response) {
		JsonPath responseJson = new JsonPath(response);
				
				for(int i = 0; i<=1;i++) {
					int counter = i + 1;
					System.out.println("Name of Repo " + counter + ": " + responseJson.get("["+i+"].name"));
				}
	}
}
