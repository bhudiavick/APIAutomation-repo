package POJO;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArraySerialization {
	
	
	
	String completeJson;
	ArrayList<SamplePOJO> allEmployeeSamplePOJOs = new ArrayList<SamplePOJO>();
	@Test
	public void createJSONArrayFromPOJO() throws JsonProcessingException {
		
		
		createEmployee("Vick", "Bhudia", "male", 38, 51000, true);
		createEmployee("Reeva", "Bhudia", "female", 8, 0, false);
		createEmployee("Leah", "Bhudia", "female", 5, 0, false);
		printFunction(allEmployeeSamplePOJOs);
		
	}
	//called by createEmployee method which will store the objectmapping for the String into the ArrayList
	public void addToArray(String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		allEmployeeSamplePOJOs.add(objectMapper.readValue(data, SamplePOJO.class));
		
	}
	//calls external method, which takes the arguments, and then builds out the POJO
	//Finally it receives the String representation of the JSON for the same POJO however
	//IN BELOW case we are also calling another method within this class which takes the String value
	//and then the addToArray method uses the objectMapper readValue method which takes this data, and maps it to the SamplePOJO
	//finally this object is added to the allEmployeeSamplePOJO array list
	public void createEmployee(String firstName, String lastName, String gender, int age, double salary, boolean married) throws JsonProcessingException {
		DataSerializeAndDeserialize dataSerializeAndDeserialize = new DataSerializeAndDeserialize();
		addToArray(dataSerializeAndDeserialize.createEmployee(firstName, lastName, gender,age,salary, married));
		//allEmployeeSamplePOJOs.add(dataSerializeAndDeserialize.createEmployee(firstName, lastName, gender,age,salary, married));
		
	}
	
	public void printFunction(ArrayList<SamplePOJO> completeList) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String completeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(completeList);
		System.out.println(completeJson);
	}
}
