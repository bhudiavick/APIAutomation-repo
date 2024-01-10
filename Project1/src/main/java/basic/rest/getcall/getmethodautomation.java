package basic.rest.getcall;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
public class getmethodautomation {
	
	public static String baseUri = "https://api.trello.com";

	public static void main(String[] args) {
		RestAssured.baseURI = baseUri;
		
		given().
			param("key", "956ce08a64264f72930ada6c9f4e10d5").
			param("token", "ATTAc6c357ddb0f28aa275c849830c4e502a7a27e70949a237e20cdb11261aea60a03BA749A5").
		when().
			get("/1/boards/qRULEFkw").
		then().
			assertThat().statusCode(200).and().log().all().
			contentType(ContentType.JSON).and().
			body("name",equalTo("Upskillings"));
		
		System.out.println("get call executed successfully");
	}

}
