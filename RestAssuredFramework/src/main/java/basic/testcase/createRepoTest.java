package basic.testcase;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import pojoclasses.CreateRepoPOJO;
import restapibase.BaseClass;
import utility.Authn;
import utility.CommonUtilFunctions;
import utility.RestFWLogger;
import utility.createURL;
import utility.payloadGenerator;

public class createRepoTest {
	Response response;
	String endPoint = createURL.getBaseURI("/user/repos");
	String bearer_token = Authn.getBearerToken();
	ObjectMapper objectMapper;
	@Test
	public void createRepositoryTestCase() throws IOException {
		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("createRepositoryTestCase");
		
		RestFWLogger.info("Step 1 - Generating payload String");
		String req_Payload = payloadGenerator.generateStringPayload("createRepo.json");
		
		RestFWLogger.info("Step 2 - Executing Create Repo call");
		response = BaseClass.postRequest(endPoint, req_Payload, bearer_token);		
		String responseString = response.getBody().asString();

		RestFWLogger.info("Step 3 - Validating repository name");
		Assert.assertEquals(getKeyValue(responseString, "name"),getKeyValue(req_Payload, "name"));
		RestFWLogger.info("Assertion for name done.");
		

		RestFWLogger.info("Step 4 - Validating repository description");
		Assert.assertEquals(getKeyValue(responseString, "description"),getKeyValue(req_Payload, "description"));
		RestFWLogger.info("Assertion for description done.");
		RestFWLogger.info(CommonUtilFunctions.getStatusMessage(response));
		
		RestFWLogger.endTestCase();
	}
	@Test
	public void createRepoTestCaseUsingPojo() throws JsonProcessingException {
		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("createRepoTestCaseUsingPojo");
		
		RestFWLogger.info("Step 1 - Generating payload String");
		pojoclasses.CreateRepoPOJO vick = new CreateRepoPOJO("APIAutomation-repo3", "Automation using Rest Assured!");
		objectMapper = new ObjectMapper();
		String req_Payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(vick);
		
		RestFWLogger.info("Step 2 - Executing Create Repo call");		
		response = BaseClass.postRequest(endPoint, req_Payload, bearer_token);
		String responseString = response.getBody().asString();
		
		RestFWLogger.info("Step 3 - Validating repository name");
		Assert.assertEquals(getKeyValue(responseString, "name"),vick.getName());
		RestFWLogger.info("Assertion for name done.");
		

		RestFWLogger.info("Step 4 - Validating repository description");
		Assert.assertEquals(getKeyValue(responseString, "description"),vick.getDescription());
		RestFWLogger.info("Assertion for description done.");
		RestFWLogger.info(CommonUtilFunctions.getStatusMessage(response));
		
		RestFWLogger.endTestCase();
	}
	
	public String getKeyValue(String payload,String key) {
		return CommonUtilFunctions.getResponseKeyValue(payload,key);
	}
	@Test
	public void deleteRepo() throws IOException {
		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("deleteRepo");
		
		RestFWLogger.info("Step 1 - Generating deletion request url based on test case");
		String req_Payload = payloadGenerator.generateStringPayload("createRepo.json");
		RestFWLogger.info("Deletion based on Payload: " + req_Payload);
		String deleteEndpoint = createURL.getBaseURI("/repos/bhudiavick/" + getKeyValue(req_Payload, "name"));
		
		RestFWLogger.info("Step 2 - Executing delete request");
		response = BaseClass.deleteRequest(deleteEndpoint, bearer_token);
		
		RestFWLogger.info("Step 3 - Validate successful deletion of provided repo " + getKeyValue(req_Payload,"name"));
		
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
		RestFWLogger.info(CommonUtilFunctions.getStatusMessage(response));
		RestFWLogger.info("Assertion for Deletion status code done.");
		
		RestFWLogger.endTestCase();
	}
	
	@Test
	public void deleteRepoFromPOJO() throws IOException {
		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("deleteRepoFromPOJO");
		
		RestFWLogger.info("Step 1 - Generating deletion request url based on test case");
		pojoclasses.CreateRepoPOJO vick = new CreateRepoPOJO("APIAutomation-repo3", "Automation using Rest Assured!");
		String req_Payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(vick);
		RestFWLogger.info("Deletion based on Payload: " + req_Payload);
		String deleteEndpoint = createURL.getBaseURI("/repos/bhudiavick/" + getKeyValue(req_Payload, "name"));
		
		RestFWLogger.info("Step 2 - Executing delete request");
		response = BaseClass.deleteRequest(deleteEndpoint, bearer_token);
		
		RestFWLogger.info("Step 3 - Validate successful deletion of provided repo " + getKeyValue(req_Payload,"name"));
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
		RestFWLogger.info(CommonUtilFunctions.getStatusMessage(response));
		RestFWLogger.info("Assertion for Deletion status code done.");
		RestFWLogger.endTestCase();
	}
}
