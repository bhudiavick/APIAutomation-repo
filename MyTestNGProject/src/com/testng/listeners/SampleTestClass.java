package com.testng.listeners;

import java.security.PublicKey;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestClass {

	
	@Test
	public void testOne() {
		System.out.println("I am testOne");
	}
	@Test(dataProvider = "dataProvider")
	public void testGetData(String s) {
		System.out.println("testGetData method, input = " + s);
	}
	
	@DataProvider
	public Object[] dataProvider() {
		return new Object[] {"A","B"};
	}
	
	@Test
	public void testThree() {
		System.out.println("I am Test Three and im due to fail");
		Assert.assertEquals(5, 7);
	}
	
	@Test
	public void testFour() {
		System.out.println("I am a skipping test");
		throw new SkipException(null);
	}
}
