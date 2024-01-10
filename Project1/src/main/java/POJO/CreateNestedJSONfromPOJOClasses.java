package POJO;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateNestedJSONfromPOJOClasses {
	
	@Test
	public void generatePOJODataForComplexNestedObhect() throws JsonProcessingException {
		
		List<SamplePOJO> employees = new ArrayList<>();
		List<Contractors> contractors = new ArrayList<>();
		List<String> bankListForSalary = new ArrayList<>();
		List<Integer> pincodesOfCityOffice = new ArrayList<>();
		
		
		SamplePOJO vick = new SamplePOJO("Vick", "Bhudia","Male", 38, 51000, true);
		SamplePOJO ree = new SamplePOJO("Ree", "Bhudia","Female", 8, 0, false);
		employees.add(ree);
		employees.add(vick);
		Contractors charlie = new Contractors("Charlie", "Brown", "2012", "2014");
		Contractors david = new Contractors("David", "Miller", "2012", "2014");
		contractors.add(charlie);
		contractors.add(david);
		bankListForSalary.add("hsbc");
		bankListForSalary.add("santander");
		bankListForSalary.add("barclays");
		pincodesOfCityOffice.add(12);
		pincodesOfCityOffice.add(700);
		pincodesOfCityOffice.add(199999);
		CompanyPFDetails details = new CompanyPFDetails("XYZ Provident Fund", "London", 2011, 100);
		ComplexPOJO createComplextData = new ComplexPOJO("ABC Corporation", "England","Veena CEO" , bankListForSalary, pincodesOfCityOffice, employees, contractors, details);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String printData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createComplextData);
		System.out.println(printData);
		
	}
}
