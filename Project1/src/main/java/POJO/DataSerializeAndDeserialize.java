package POJO;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSerializeAndDeserialize {
	@Test
	public void createDataFromPOJO() throws JsonProcessingException {
		String employeeJSON = createEmployee("Vick", "Bhudia", "male",38,51000, true);
		System.out.println(employeeJSON);
		getPOJOFromObject(employeeJSON);
	}
	
	public void getPOJOFromObject(String employeeJSON) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		//convert a json string into a POJO
		SamplePOJO employeeObject = objectMapper.readValue(employeeJSON, SamplePOJO.class);
		System.out.println("First Name - " + employeeObject.getFirstName() );
		System.out.println("Last Name - " + employeeObject.getLastName() );
		System.out.println("Gender - " + employeeObject.getGender());
		System.out.println("Age - " + employeeObject.getAge() );
		System.out.println("Salary - " + employeeObject.getSalary());
		System.out.println("Married? - " + employeeObject.isMarried());
		
	}
	
	//builds the SamplePOJO from the arguments provided - then uses objectMaper to generate a Json format as String
	public String createEmployee(String firstName, String lastName, String gender, int age, double salary, boolean married) throws JsonProcessingException {
		SamplePOJO employeePojo = new SamplePOJO(firstName, lastName, gender,age,salary, married);
		ObjectMapper objectMapper = new ObjectMapper();
		return (objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojo));
		
	}
	
}
