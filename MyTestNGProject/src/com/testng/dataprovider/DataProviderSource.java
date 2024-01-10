package com.testng.dataprovider;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderSource {
	
	@DataProvider(name = "scenarioData")
	public static Object[][] getScenarioData(Method method){
		String testCase = method.getName(); 
		if("scenario1".equals(testCase)) {
			return new Object[][] {{"Scenario1 Data"}};
		} else if ("scenario2".equals(testCase)) {
			return new Object[][] {{"Scenario2 Data"}};
		}else {
			return new Object[][] {{"Common scenario Data"}};
		}
	}
	@DataProvider(name = "TestType")
	public static Object[][] getTestTypeData(ITestContext context){
		String testName = context.getName(); //returns the test Type name
		if("IntegrationLevel".equals(testName)) {
			return new Object[][] {{"Integration Test Data"}};
		} else if ("AcceptanceLevel".equals(testName)) {
			return new Object[][] {{"Acceptance Test Data"}};
		}else {
			return new Object[][] {{"Common Test Data"}};
		}
	}
	
}
	


