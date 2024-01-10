package com.testing.training;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	@Test
	@Parameters("browser")
	public void testCaseOne(String browser) {
		System.out.println("browser passed : " + browser);
	}
	@Test
	@Parameters({"username","password"})
	public void testCaseTwo(String username, String password) {
		System.out.println("Parameter for Username : " + username);
		System.out.println("Parameter for Password : " + password);
	}
}
