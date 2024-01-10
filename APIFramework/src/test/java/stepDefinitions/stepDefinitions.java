package stepDefinitions;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.TestDataBuilder;
import resource.commonUtils.RestLogger;
import resource.commonUtils.utils;

public class stepDefinitions extends utils {
	TestDataBuilder testDataBuilder = new TestDataBuilder();
	ObjectMapper objectMapper;
	JsonPath jsonPath;
	String payload;
	Response response;

	@Given("Create Repo Payload")
	public void create_repo_payload() throws JsonProcessingException {
		// Write code here that turns the phrase above into concrete actions

		objectMapper = new ObjectMapper();
		payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testDataBuilder.createRepoPayload());

	}

	@Given("Starting TestCase {string}")
	public void starting_test_case(String testCaseName) {
		RestLogger.initLogger();
	    // Write code here that turns the phrase above into concrete actions
	    RestLogger.startTestCase(testCaseName);
	}
	@Then("Ending TestCase")
	public void ending_test_case() {

	    // Write code here that turns the phrase above into concrete actions
		RestLogger.endTestCase();
	}

	@When("User calls Create API {string} POST API Call")
	public void user_calls_post_api_call(String resourcePath) {

		// Write code here that turns the phrase above into concrete actions
		response = postRequest(resourcePath, payload);
		RestLogger.info("Post status code is "+ response.getStatusCode());
	}

	@When("User calls Delete API {string}")
	public void user_calls_delete_api(String resourcePath) {

		response = deleteRequest(resourcePath, testDataBuilder.getRepoName());
		RestLogger.info("Delete status code is "+ response.getStatusCode());
	}

	@Then("API Call is Successful with {int} status code")
	public void api_call_is_successful_with_status_code(int status_code) {

		// Write code here that turns the phrase above into concrete actions
		assertEquals(status_code, response.getStatusCode());


	}

	@Then("Verify Repository {string} is {string}")
	public void verify_created(String response_key, String repo_name) {

		// Write code here that turns the phrase above into concrete actions
		jsonPath = new JsonPath(response.getBody().asString());
		String key_value = jsonPath.get(response_key);
		assertEquals(repo_name, key_value);
		RestLogger.info("Actual  : " + repo_name + " is " + key_value + " and was expecting " + repo_name);
	}




}
