package JSONResponseValidation;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class handleJSONArray {

	public static String baseUri = "https://api.trello.com";
	
	@Test
	public void validateResponseBody() {
		RestAssured.baseURI = baseUri;
		
		Response response = given().
			param("key", "956ce08a64264f72930ada6c9f4e10d5").
			param("token", "ATTAc6c357ddb0f28aa275c849830c4e502a7a27e70949a237e20cdb11261aea60a03BA749A5").
		when().
			get("/1/boards/qRULEFkw").
		then().
			assertThat().statusCode(200).and().log().all().
			contentType(ContentType.JSON).extract().response();
		
		String  jsonResponse = response.asString();
		
		JsonPath jsonPath = new JsonPath(jsonResponse);
		
		System.out.println("Pref : " + jsonPath.get("prefs.hideVotes"));
		System.out.println("Pref : " + jsonPath.get("prefs.switcherViews[2].viewType"));
		
		
		
		System.out.println("get call executed successfully");
	}	
	}

